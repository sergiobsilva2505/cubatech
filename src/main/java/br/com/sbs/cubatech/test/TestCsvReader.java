package br.com.sbs.cubatech.test;

import br.com.sbs.cubatech.category.Category;
import br.com.sbs.cubatech.category.SubCategory;
import br.com.sbs.cubatech.course.Course;
import br.com.sbs.cubatech.reader.CategoriesFileReader;
import br.com.sbs.cubatech.reader.CoursesFileReader;
import br.com.sbs.cubatech.reader.SubCategoriesFileReader;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestCsvReader {

    public static void main(String[] args) throws IOException {

        CategoriesFileReader categoriesFileReader = new CategoriesFileReader();
        SubCategoriesFileReader subCategoriesFileReader = new SubCategoriesFileReader();
        CoursesFileReader coursesFileReader = new CoursesFileReader();


        List<Category> categoryList = categoriesFileReader.readCategories();
        Map<String, Category> categoryMap = categoryList.stream().collect(Collectors.toMap(Category::getUrlCode, Function.identity()));

        List<SubCategory> subCategoryList = subCategoriesFileReader.readSubCategories(categoryMap);
        Map<String, SubCategory> subCategoryMap = subCategoryList.stream().collect(Collectors.toMap(SubCategory::getUrlCode, Function.identity()));

        List<Course> courseList = coursesFileReader.readCourses(subCategoryMap);

        System.out.println("\n----===> CATEGORIES <===----");
        categoryList.forEach(System.out::println);
        System.out.println("\n----===> SUB CATEGORIES <===----");
        subCategoryList.forEach(System.out::println);
        System.out.println("\n----===> COURSES <===----");
        courseList.forEach(System.out::println);
    }

}
