package br.com.sbs.cubatech.test;

import br.com.sbs.cubatech.category.Category;
import br.com.sbs.cubatech.category.Status;
import br.com.sbs.cubatech.category.SubCategory;
import br.com.sbs.cubatech.course.Course;
import br.com.sbs.cubatech.reader.CategoriesFileReader;
import br.com.sbs.cubatech.reader.CoursesFileReader;
import br.com.sbs.cubatech.reader.SubCategoriesFileReader;

import java.io.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestHtmlWriter {

    public static void main(String[] args) throws IOException {

        CategoriesFileReader categoriesFileReader = new CategoriesFileReader();
        SubCategoriesFileReader subCategoriesFileReader = new SubCategoriesFileReader();
        CoursesFileReader coursesFileReader = new CoursesFileReader();

        List<Category> categories = categoriesFileReader.readCategories();
        Map<String, Category> categoryMap = categories.stream().collect(Collectors.toMap(Category::getUrlCode, Function.identity()));

        List<SubCategory> subCategories = subCategoriesFileReader.readSubCategories(categoryMap);
        Map<String, SubCategory> subCategoryMap = subCategories.stream().collect(Collectors.toMap(SubCategory::getUrlCode, Function.identity()));
        List<Course> courses = coursesFileReader.readCourses(subCategoryMap);

        String outputFile = "index.html";
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFile));

        String textValues = "";


        for (Category category: categories) {
            String fieldsNameDescriptionTotalCourses = "";
            for (SubCategory activeSubCategory : category.getActiveSubCategories()) {
                fieldsNameDescriptionTotalCourses += String.format("""
                                <div>%s</div>
                                <div>%s</div>
                                <div>%d</div>
                                """, activeSubCategory.getName(), activeSubCategory.getDescription(), activeSubCategory.getTotalCourses());
            }

            textValues += String.format("""
                        <tr>
                            <td>%s</td>
                            <td>%s</td>
                            <td>%s</td>
                            <td>%s</td>
                            <td>%3d</td>
                            <td>%3d</td>
                            <td>%s</td>
                        </tr>
                """, category.getName(), category.getDescription(), category.getIconPath(), category.getColorCode(), category.getTotalCourses(), category.totalTimeToFinishPerCategory(), fieldsNameDescriptionTotalCourses);
        }

        String text = String.format("""
                <!DOCTYPE html>
                <html lang="pt">
                <head>
                    <meta charset="UTF-8">
                    <title>Document</title>
                    <link rel="stylesheet" href="style.css">
                </head>
                <body>
                    <h2>Categorias</h2><br>
                    <table>
                        <tr>
                            <th>Nome</th>
                            <th>Descrição</th>
                            <th>Icone</th>
                            <th>Cor</th>
                            <th>Total de cursos</th>
                            <th>Total de horas</th>
                            <th>SubCategorias</th>
                        </tr>
                        %s
                    </table>
                </body>
                </html>
                """, textValues);


        bufferedWriter.write(text);
        bufferedWriter.close();
    }


}
