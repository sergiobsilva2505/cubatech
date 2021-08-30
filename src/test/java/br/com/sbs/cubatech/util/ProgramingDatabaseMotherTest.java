package br.com.sbs.cubatech.util;


import br.com.sbs.cubatech.category.Category;
import br.com.sbs.cubatech.category.CategoryRepository;
import br.com.sbs.cubatech.course.Course;
import br.com.sbs.cubatech.course.CourseRepository;
import br.com.sbs.cubatech.subcategory.SubCategory;
import br.com.sbs.cubatech.subcategory.SubCategoryRepository;
import br.com.sbs.cubatech.util.builder.CategoryBuilder;
import br.com.sbs.cubatech.util.builder.CourseBuilder;
import br.com.sbs.cubatech.util.builder.SubCategoryBuilder;

import java.util.Arrays;

public class ProgramingDatabaseMotherTest {

    private CategoryRepository categoryRepository;
    private SubCategoryRepository subCategoryRepository;
    private CourseRepository courseRepository;

    public ProgramingDatabaseMotherTest(CategoryRepository categoryRepository, SubCategoryRepository subCategoryRepository, CourseRepository courseRepository) {
        this.categoryRepository = categoryRepository;
        this.subCategoryRepository = subCategoryRepository;
        this.courseRepository = courseRepository;
        this.courseRepository.deleteAll();
        this.subCategoryRepository.deleteAll();
        this.categoryRepository.deleteAll();
    }

    public void create() {
        Category category1 = CategoryBuilder.category1();
        Category category2 = CategoryBuilder.category2();
        Category category3 = CategoryBuilder.category3();
        categoryRepository.saveAll(Arrays.asList(category1, category2, category3));

        SubCategory subCategory1 = SubCategoryBuilder.subCategory1(category1);
        SubCategory subCategory2 = SubCategoryBuilder.subCategory2(category1);
        SubCategory subCategory3 = SubCategoryBuilder.subCategory3(category1);
        SubCategory subCategory4 = SubCategoryBuilder.subCategory4(category1);
        SubCategory subCategory5 = SubCategoryBuilder.subCategory5(category2);
        subCategoryRepository.saveAll(Arrays.asList(subCategory1, subCategory2, subCategory3, subCategory4, subCategory5));

        Course course1 = CourseBuilder.course1(subCategory5);
        Course course2 = CourseBuilder.course2(subCategory2);
        Course course3 = CourseBuilder.course3(subCategory1);
        Course course4 = CourseBuilder.course4(subCategory1);
        Course course5 = CourseBuilder.course5(subCategory1);
        courseRepository.saveAll(Arrays.asList(course1, course2, course3, course4, course5));

    }
}
