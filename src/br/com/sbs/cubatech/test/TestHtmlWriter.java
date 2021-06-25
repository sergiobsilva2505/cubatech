package br.com.sbs.cubatech.test;

import br.com.sbs.cubatech.category.Category;
import br.com.sbs.cubatech.category.Status;
import br.com.sbs.cubatech.category.SubCategory;
import br.com.sbs.cubatech.course.Course;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TestHtmlWriter {

    public static void main(String[] args) throws IOException {

        CsvFileReader csvFileReader = new CsvFileReader();
//        List<Category> categories = readCsvFile();

        List<Category> categories = csvFileReader.readCategories();
        List<SubCategory> subCategories = csvFileReader.readSubCategories(categories);
        List<Course> courses = csvFileReader.readCourses(subCategories);

        List<SubCategory> list = subCategories.stream()
                .filter(subCategory -> subCategory.getStatus() == Status.INATIVA)
                .collect(Collectors.toList());

        list.forEach(System.out::println);

//        writeCsvFile(categories);

    }

    private static void writeCsvFile(List<Category> categories) throws IOException {
        String outputFile = "index.html";
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFile));

        String textValues = "";

        for (Category category: categories) {
            textValues += String.format("""
                        <tr>
                            <td>%s</td>
                            <td>%s</td>
                            <td>%s</td>
                            <td>%s</td>
                            <td>%d</td>
                            <td>%d</td>
                        </tr>
                """, category.getName(), category.getDescription(), category.getIconPath(), category.getColorCode(), 9, 100);
        }

        String text = String.format("""
                <!DOCTYPE html>
                <html lang="pt">
                <head>
                    <meta charset="UTF-8">
                    <title>Document</title>
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
                        </tr>
                        %s
                    </table>
                </body>
                </html>
                """, textValues);

        bufferedWriter.write(text);
        bufferedWriter.close();
    }

//    private static List<Category> readCsvFile() throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new FileReader("Categoria.csv"));
//
//        List<Category> categoryList = new ArrayList<>();
//
//        String headerCategory = bufferedReader.readLine().toUpperCase();
//        String[] categoryColumnName = headerCategory.split(",");
//
//        String columnsValueInCsvCategory = bufferedReader.readLine();
//
//        String[] sepratorColumns = null;
//
//        while (columnsValueInCsvCategory != null){
//
//            sepratorColumns = columnsValueInCsvCategory.split(",");
//
//            String name = sepratorColumns[0];
//            String urlCode = sepratorColumns[1];
//            Integer order = sepratorColumns[2] == "" ? null : Integer.parseInt(sepratorColumns[2]);
//            String description = sepratorColumns[3];
//            Boolean active = sepratorColumns[4] == "ATIVA" ? true : false;
//            String iconPath = sepratorColumns[5];
//            String colorCode = sepratorColumns[6];
//
//            Category category = new Category(name, urlCode, order, description, active, iconPath, colorCode);
//            categoryList.add(category);
//
//            columnsValueInCsvCategory = bufferedReader.readLine();
//
//        }
//        bufferedReader.close();
//
//        return categoryList;
//    }
}
