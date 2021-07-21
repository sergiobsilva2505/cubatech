package br.com.sbs.cubatech.test;

import br.com.sbs.cubatech.category.Category;
import br.com.sbs.cubatech.category.SubCategory;
import br.com.sbs.cubatech.course.Course;
import br.com.sbs.cubatech.reader.CategoriesFileReader;
import br.com.sbs.cubatech.reader.CoursesFileReader;
import br.com.sbs.cubatech.reader.SubCategoriesFileReader;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestGenerateData {

    public static void main(String[] args) throws IOException {

        CategoriesFileReader categoriesFileReader = new CategoriesFileReader();
        SubCategoriesFileReader subCategoriesFileReader = new SubCategoriesFileReader();
        CoursesFileReader coursesFileReader = new CoursesFileReader();

        List<Category> categories = categoriesFileReader.readCategories();
        Map<String, Category> categoryMap = categories.stream().collect(Collectors.toMap(Category::getUrlCode, Function.identity()));

        List<SubCategory> subCategories = subCategoriesFileReader.readSubCategories(categoryMap);
        Map<String, SubCategory> subCategoryMap = subCategories.stream().collect(Collectors.toMap(SubCategory::getUrlCode, Function.identity()));
        List<Course> courses = coursesFileReader.readCourses(subCategoryMap);

        String outputFile = "src/main/resources/data.sql";

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFile));

        String textInsertCategory = "";
        String textInsertSubCategory = "";
        String textInsertCourse = "";

        for (Category category: categories) {
            textInsertCategory += String.format("""
                            INSERT INTO category (name, urlCode, orderInSystem, description, status, iconPath, colorCode) VALUES ('%s', '%s', %s, '%s',  '%s',  '%s',  '%s');
                            """, category.getName(), category.getUrlCode(), category.getOrderInSystem(), category.getDescription(), category.getStatus(), category.getIconPath(), category.getColorCode());
        }

        for (SubCategory subCategory: subCategories) {
            Category category = subCategory.getCategory();
            textInsertSubCategory += String.format("""
                    INSERT INTO subCategory (name, urlCode, orderInSystem, description, status, category_id) values ('%s','%s',%d,'%s','%s',(SELECT id FROM category WHERE urlCode = '%s'));
                    """,subCategory.getName(), subCategory.getUrlCode(), subCategory.getOrder(), subCategory.getDescription(), subCategory.getStatus(), category.getUrlCode());
        }

        for (Course course : courses) {
            SubCategory subCategory = course.getSubCategory();
            textInsertCourse += String.format("""
                    INSERT INTO course (name, urlCode, timeToFinishInHours, courseVisibility, targetAudience, instructor, summary, skillsDeveloped, subCategory_id) VALUES ("%s", "%s", %s, "%s", "%s", "%s", "%s","%s",(SELECT id FROM subCategory WHERE urlCode = "%s" ));                                        
                    """, course.getName(), course.getUrlCode(), course.getTimeToFinishInHours(), course.getCourseVisibility(), course.getTargetAudience(),course.getInstructor(), course.getSummary(), course.getSkillsDeveloped(), subCategory.getUrlCode());

        }

        bufferedWriter.write(textInsertCategory);
        bufferedWriter.write(textInsertSubCategory);
        bufferedWriter.write(textInsertCourse);

        bufferedWriter.close();

    }
}
