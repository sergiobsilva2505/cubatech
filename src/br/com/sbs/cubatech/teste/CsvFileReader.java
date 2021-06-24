package br.com.sbs.cubatech.teste;

import br.com.sbs.cubatech.category.Category;
import br.com.sbs.cubatech.category.SubCategory;
import br.com.sbs.cubatech.course.Course;
import br.com.sbs.cubatech.course.CourseVisibility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CsvFileReader {

    static List<Category> readCategories() throws IOException {
        String file = "Categoria.csv";
        List<Category> categoryList = new ArrayList<>();

        var bufferedReader = new BufferedReader(new FileReader(file));

        String headerLine = bufferedReader.readLine().toUpperCase();
        String line = bufferedReader.readLine();

        String[] categoryColumnName = headerLine.split(",");

        while (line != null){

            String[] valuesCategoryColumns = line.split(",");

            String name = valuesCategoryColumns[0];
            String urlCode = valuesCategoryColumns[1];
            Integer order = valuesCategoryColumns[2] == "" ? null : Integer.parseInt(valuesCategoryColumns[2]);
            String description = valuesCategoryColumns[3];
            Boolean active = valuesCategoryColumns[4] == "ATIVA" ? true : false;
            String iconPath = valuesCategoryColumns[5];
            String colorCode = valuesCategoryColumns[6];

            Category category = new Category(name, urlCode, order, description, active, iconPath, colorCode );
            categoryList.add(category);

            line = bufferedReader.readLine();
        }

//        String headerName = columnsName[0];
//        String headerUrlCode = columnsName[1];
//        String headerOrder = columnsName[2];
//        String headerDescription = columnsName[3];
//        String headerStatus = columnsName[4];
//        String headerIcon = columnsName[5];
//        String headerColor = columnsName[6];

//        System.out.println("---===> CATEGORIES <===---");
//        System.out.format("%-15s - %-15s - %-150s - %-6s - %6s - %-100s - %-8s%n", headerName, headerUrlCode, headerDescription, headerStatus, headerOrder, headerIcon, headerColor);

        bufferedReader.close();

        return categoryList;
    }

    static List<SubCategory> readSubCategories() throws IOException {

        List<Category> categoryList = readCategories();

        String file = "Subcategoria.csv";
        List<SubCategory> listSubCategory = new ArrayList<>();

        var bufferedReader = new BufferedReader(new FileReader(file));

        String headerLine = bufferedReader.readLine().toUpperCase();
        String line = bufferedReader.readLine();

        String[] subCategoriesColumnName = headerLine.split(",");

        while (line != null ){

            String[] valuesSubCategoryColumns = line.split(",");

            String name = valuesSubCategoryColumns[0];
            String urlCode = valuesSubCategoryColumns[1];
            Integer order = valuesSubCategoryColumns[2] == "" ? null : Integer.parseInt(valuesSubCategoryColumns[2]);
            String description = valuesSubCategoryColumns[3];
            Boolean active = valuesSubCategoryColumns[4] == "ATIVA" ? true : false;
            String categoryUrlCode = valuesSubCategoryColumns[5];


            Optional<Category> category = categoryList.stream()
                    .filter(category1 -> category1.getUrlCode().equals(categoryUrlCode))
                    .findAny();
            if(!category.isEmpty()){
                SubCategory subCategory = new SubCategory(name, urlCode, order, description,active, category.get());
                listSubCategory.add(subCategory);
            }

            line = bufferedReader.readLine();
        }

//        String name = columnsName[0];
//        String urlCode = columnsName[1];
//        String order = columnsName[2];
//        String description = columnsName[3];
//        String active = columnsName[4];
//        String category = columnsName[5];

//        System.out.println("---===> SUB CATEGORIES <===---");
//        System.out.format("%-30s - %-30s - %6s - %-155s - %s - %-8s %n", name, urlCode, order, description, active, category);

        bufferedReader.close();

        return listSubCategory;
    }

    static List<Course> readCourses() throws IOException {

        List<SubCategory> subCategoryList = readSubCategories();

        String file = "Curso.csv";
        List<Course> courseList = new ArrayList<>();

        var bufferedReader = new BufferedReader(new FileReader(file));

        String headerLine = bufferedReader.readLine().toUpperCase();
        String line = bufferedReader.readLine();

        String[] courseColumnName = headerLine.split(",");

        while ( line != null){

            String[] courseColumnValues = line.split(",");

            String name = courseColumnValues[0];
            String courseUrlCode = courseColumnValues[1];
            Integer timeToFinishInHours = courseColumnValues[2] == "" ? null : Integer.parseInt(courseColumnValues[2]);
            CourseVisibility courseVisibility = courseColumnValues[3] == "PRIVADA" ? CourseVisibility.PRIVATE : CourseVisibility.PUBLIC;
            String targetAudience = courseColumnValues[4];
            String instructor = courseColumnValues[5];
            String summary = courseColumnValues[6];
            String skillsDeveloped = courseColumnValues[7];
            String subCategoryUrlCode = courseColumnValues[8];

            Optional<SubCategory> subCategory = subCategoryList.stream()
                    .filter(subCategory1 -> subCategory1.getUrlCode().equals(subCategoryUrlCode))
                    .findAny();

            if(!subCategory.isEmpty()){
                Course course = new Course(name, courseUrlCode, timeToFinishInHours, courseVisibility, targetAudience,  instructor, summary, skillsDeveloped,  subCategory.get());
                courseList.add(course);
            }

            line = bufferedReader.readLine();


        }


        return courseList;

    }


}
