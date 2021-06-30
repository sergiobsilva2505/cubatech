package br.com.sbs.cubatech.test;

import br.com.sbs.cubatech.category.Category;
import br.com.sbs.cubatech.category.SubCategory;
import br.com.sbs.cubatech.course.Course;
import br.com.sbs.cubatech.reader.CsvFileReader;

import java.io.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestHtmlWriter {

    public static void main(String[] args) throws IOException {

        CsvFileReader csvFileReader = new CsvFileReader();

        List<Category> categories = csvFileReader.readCategories();
        Map<String, Category> categoryMap = categories.stream().collect(Collectors.toMap(Category::getUrlCode, Function.identity()));

        List<SubCategory> subCategories = csvFileReader.readSubCategories(categoryMap);
        Map<String, SubCategory> subCategoryMap = subCategories.stream().collect(Collectors.toMap(SubCategory::getUrlCode, Function.identity()));
        List<Course> courses = csvFileReader.readCourses(subCategoryMap);

        String outputFile = "index.html";
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFile));


        String cousesNames = courses.stream().map(Course::getName).collect(Collectors.joining(","));

        String textValues = "";

        for (Category category: categories) {
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
                """, category.getName(), category.getDescription(), category.getIconPath(), category.getColorCode(), category.getTotalCourses(), category.totalTimeToFinishPerCategory(), category.getSubCategoryName());
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
