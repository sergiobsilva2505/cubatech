package br.com.sbs.cubatech.test;

import br.com.sbs.cubatech.category.Category;
import br.com.sbs.cubatech.category.Status;
import br.com.sbs.cubatech.category.SubCategory;
import br.com.sbs.cubatech.course.Course;
import br.com.sbs.cubatech.course.CourseVisibility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class CsvFileReader {

    public List<Category> readCategories() throws IOException {

        List<Category> categoryList = new ArrayList<>();

        var bufferedReader = new BufferedReader(new FileReader("Categoria.csv"));

        bufferedReader.readLine().toUpperCase();
        String line = bufferedReader.readLine();

//        String[] categoryColumnName = headerLine.split(",");

        while (line != null){

            String[] valuesCategoryColumns = line.split(",");

            String name = valuesCategoryColumns[0];
            String urlCode = valuesCategoryColumns[1];
            Integer order = valuesCategoryColumns[2] == "" ? null : Integer.parseInt(valuesCategoryColumns[2]);
            String description = valuesCategoryColumns[3];
            Status status = valuesCategoryColumns[4] == "ATIVA" ? Status.ATIVA : Status.INATIVA;
            String iconPath = valuesCategoryColumns[5];
            String colorCode = valuesCategoryColumns[6];

            Category category = new Category(name, urlCode, order, description, status, iconPath, colorCode );
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

//        System.out.format("%-15s - %-15s - %-150s - %-6s - %6s - %-100s - %-8s%n", headerName, headerUrlCode, headerDescription, headerStatus, headerOrder, headerIcon, headerColor);

        bufferedReader.close();

        return categoryList;
    }

    public List<SubCategory> readSubCategories(Map<String, Category> categories) throws IOException {

        List<SubCategory> listSubCategory = new ArrayList<>();

        var bufferedReader = new BufferedReader(new FileReader("Subcategoria.csv"));

        bufferedReader.readLine().toUpperCase();
        String line = bufferedReader.readLine();


        while (line != null ){

            String[] valuesSubCategoryColumns = line.split(",");

            String name = valuesSubCategoryColumns[0];
            String urlCode = valuesSubCategoryColumns[1];
            Integer order = valuesSubCategoryColumns[2] == "" ? null : Integer.parseInt(valuesSubCategoryColumns[2]);
            String description = valuesSubCategoryColumns[3];
            Status status = valuesSubCategoryColumns[4].equals("ATIVA")  ? Status.ATIVA : Status.INATIVA;
            String categoryUrlCode = valuesSubCategoryColumns[5];

            Category category =  categories.get(categoryUrlCode);
            SubCategory subCategory = new SubCategory(name, urlCode, order, description, status, category);
            listSubCategory.add(subCategory);
            category.addSubCategories(subCategory);

            line = bufferedReader.readLine();
        }


        bufferedReader.close();

        return listSubCategory;
    }

    public List<Course> readCourses(Map<String, SubCategory> subCategories) throws IOException {

        List<Course> courseList = new ArrayList<>();

        var bufferedReader = new BufferedReader(new FileReader("Curso.csv"));

        bufferedReader.readLine().toUpperCase();
        String line = bufferedReader.readLine();

//        String[] courseColumnName = headerLine.split(",");

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

            if(!subCategories.isEmpty()){
                Course course = new Course(name, courseUrlCode, timeToFinishInHours, courseVisibility, targetAudience,  instructor, summary, skillsDeveloped,  subCategories.get(subCategoryUrlCode));
                courseList.add(course);

            }

            line = bufferedReader.readLine();
        }

        bufferedReader.close();

        return courseList;

    }

}
