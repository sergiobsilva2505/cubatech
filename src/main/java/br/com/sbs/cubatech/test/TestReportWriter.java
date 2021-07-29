package br.com.sbs.cubatech.test;

import br.com.sbs.cubatech.category.Category;
import br.com.sbs.cubatech.category.CategoryDao;
import br.com.sbs.cubatech.category.SubCategory;
import br.com.sbs.cubatech.category.SubCategoryDao;
import br.com.sbs.cubatech.course.Course;
import br.com.sbs.cubatech.course.CourseDao;
import br.com.sbs.cubatech.util.JPAUtil;

import javax.persistence.EntityManager;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class TestReportWriter {

    public static void main(String[] args){

        EntityManager entityManager = JPAUtil.getEntityManager();

        CategoryDao categoryDao = new CategoryDao(entityManager);
        SubCategoryDao subCategoryDao = new SubCategoryDao(entityManager);
        CourseDao courseDao = new CourseDao(entityManager);

        List<Category> categoryList = categoryDao.findAllByStatusActiveOrderByOrderInSystemAsc();
        List<SubCategory> subCategoryList = subCategoryDao.findAllByStatusActiveOrderByOrderInSystemAsc();
        List<Course> courseList = courseDao.getPublicCourse();
        List<SubCategory> subCategoryNames = subCategoryDao.findAllByDescriptionIsNullOrEmpty();

        //BufferedWriter bufferedWriter = null;
        String htmlPageCode;

        String tableRowResultCategory = "";
        String tableRowResultSubCategory = "";
        String tableRowResultCourse = "";
        String tableRowResultNames = "";

        for (Category category: categoryList) {
            tableRowResultCategory += String.format("""
                    <tr>
                        <td>%d</td>
                        <td>%s</td>
                        <td>%s</td>
                        <td>%s</td>
                        <td>%s</td>
                        <td>%s</td>
                        <td>%d</td>
                        <td>%s</td>
                        <td>%s</td>
                    </tr>
                    """, category.getId(), category.getName(), category.getUrlCode(), category.getDescription(),
                    category.getStudyGuide(), category.getStatus(), category.getOrderInSystem(),
                    category.getIconPath(), category.getColorCode());
        }

        for (SubCategory subCategory: subCategoryList ) {
            tableRowResultSubCategory += String.format("""
                    <tr>
                        <td>%d</td>
                        <td>%s</td>
                        <td>%s</td>
                        <td>%s</td>
                        <td>%s</td>
                        <td>%d</td>
                        <td>%s</td>
                        <td>%s</td>
                    </tr>
                    
                    """, subCategory.getId(), subCategory.getName(), subCategory.getUrlCode(),
                    subCategory.getDescription(), subCategory.getStudyGuide(), subCategory.getOrder(),
                    subCategory.getStatus(), subCategory.getCategory().getName());
        }

        for (Course course: courseList ) {
            tableRowResultCourse += String.format("""
                    <tr>
                        <td>%d</td>
                        <td>%s</td>
                        <td>%s</td>
                        <td>%d</td>
                        <td>%s</td>
                        <td>%s</td>
                        <td>%s</td>
                        <td>%s</td>
                        <td>%s</td>
                        <td>%s</td>
                    </tr>
                    
                    """, course.getId(), course.getName(), course.getUrlCode(),
                    course.getTimeToFinishInHours(), course.getTargetAudience(),
                    course.getCourseVisibility(), course.getInstructor(), course.getSummary(),
                    course.getSkillsDeveloped(), course.getSubCategory().getName());
        }

        for (SubCategory subCategory: subCategoryNames) {
            tableRowResultNames += String.format("""
                    <tr>
                        <td>%s</td>
                    </tr>                
                    """, subCategory.getName());
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("relatorionovo.html")); ){

            htmlPageCode = String.format("""
                            <!DOCTYPE html>
                            <head>
                            <meta charset="UTF-8">
                            <title>Cubatech DB - Relatório</title>
                            <link rel="stylesheet" href="style.css">
                            </head>
                            <body>
                                <h1>Category</h1>
                                <br>
                                <table>
                                    <tr>
                                        <th>Id</th>
                                        <th>Name</th>
                                        <th>UrlCode</th>
                                        <th>Description</th>
                                        <th>StudyGuide</th>
                                        <th>Status</th>
                                        <th>Order In System</th>
                                        <th>IconPath</th>
                                        <th>Colorcode</th>
                                    </tr>
                                    %s
                                </table>
                                <br>
                                <br>
                                <h1>Sub Category</h1><br>
                                <table>
                                    <tr>
                                        <th>Id</th>
                                        <th>Name</th>
                                        <th>UrlCode</th>
                                        <th>Description</th>
                                        <th>Study Guide</th>
                                        <th>Order In System</th>
                                        <th>Status</th>
                                        <th>Category_id</th>
                                    </tr>
                                    %s
                                </table>
                                <br>
                                <br>
                                <h1>Courses</h1><br>
                                <table>
                                    <tr>
                                        <th>Id</th>
                                        <th>Name</th>
                                        <th>UrlCode</th>
                                        <th>TimeToFinishInHours</th>
                                        <th>Target Audience</th>
                                        <th>Course Visibility</th>
                                        <th>Instructor</th>
                                        <th>Summary</th>
                                        <th>Skills Developed</th>
                                        <th>SubCategory_id</th>
                                    </tr>
                                    %s
                                </table>
                                <h3>SubCategories whitout description</h3><br>
                                <table>
                                    <tr>
                                        <th>Name</th>
                                    </tr>
                                    %s
                                </table>
                            </body>
                            </html>
                    """, tableRowResultCategory, tableRowResultSubCategory, tableRowResultCourse, tableRowResultNames);
            bufferedWriter.write(htmlPageCode);

        } catch (NullPointerException | IOException e){
            e.printStackTrace();
        }
    }
}
