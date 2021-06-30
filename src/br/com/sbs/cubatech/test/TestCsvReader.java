package br.com.sbs.cubatech.test;

import br.com.sbs.cubatech.category.Category;
import br.com.sbs.cubatech.category.SubCategory;
import br.com.sbs.cubatech.course.Course;
import br.com.sbs.cubatech.reader.CsvFileReader;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestCsvReader {

    public static void main(String[] args) throws IOException {

        CsvFileReader csvFileReader = new CsvFileReader();

        List<Category> categoryList = csvFileReader.readCategories();
        Map<String, Category> categoryMap = categoryList.stream().collect(Collectors.toMap(Category::getUrlCode, Function.identity()));

        List<SubCategory> subCategoryList = csvFileReader.readSubCategories(categoryMap);
        Map<String, SubCategory> subCategoryMap = subCategoryList.stream().collect(Collectors.toMap(SubCategory::getUrlCode, Function.identity()));

        List<Course> courseList = csvFileReader.readCourses(subCategoryMap);

        System.out.println("\n---===> CATEGORIES <===---");
        categoryList.forEach(System.out::println);
        System.out.println("\n---===> SUB CATEGORIES <===---");
        subCategoryList.forEach(System.out::println);
        System.out.println("\n---===> COURSES <===---");
        courseList.forEach(System.out::println);
    }

}
