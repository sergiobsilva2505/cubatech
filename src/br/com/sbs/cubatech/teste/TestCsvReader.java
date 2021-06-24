package br.com.sbs.cubatech.teste;

import br.com.sbs.cubatech.category.Category;
import br.com.sbs.cubatech.category.SubCategory;
import br.com.sbs.cubatech.course.Course;

import java.io.IOException;
import java.util.List;

public class TestCsvReader {

    public static void main(String[] args) throws IOException {

        List<Category> categoryList = CsvFileReader.readCategories();
        List<SubCategory> subCategoryList = CsvFileReader.readSubCategories();
        List<Course> courseList = CsvFileReader.readCourses();

        System.out.println("\n---===> CATEGORIES <===---");
        categoryList.forEach(System.out::println);
        System.out.println("\n---===> SUB CATEGORIES <===---");
        subCategoryList.forEach(System.out::println);
        System.out.println("\n---===> COURSES <===---");
        courseList.forEach(System.out::println);
    }

}
