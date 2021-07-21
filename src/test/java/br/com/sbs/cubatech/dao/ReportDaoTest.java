package br.com.sbs.cubatech.dao;

import br.com.sbs.cubatech.category.Category;
import br.com.sbs.cubatech.category.SubCategory;
import br.com.sbs.cubatech.course.Course;
import br.com.sbs.cubatech.report.ReportDao;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ReportDaoTest {

    private ReportDao reportDao;

    @Test
    void shouldReturnListActiveCategory(){
        this.reportDao = new ReportDao();
        List<Category> categoryList = reportDao.getActiveCategory();
        assertThat(categoryList)
                .hasSize(2)
                .extracting(Category::getUrlCode)
                .contains("programacao", "devops");
    }

    @Test
    void shouldReturnListOfActiveSubCategories(){
        this.reportDao = new ReportDao();
        List<SubCategory> subCategoryList = reportDao.getActiveSubCategory();
        assertThat(subCategoryList)
                .hasSize(4)
                .extracting(SubCategory::getUrlCode)
            .contains("java", "java-e-persistencia", "php", "builds-e-controle-de-versao");

    }

    @Test
    void shouldReturnCourseListWithAllPublicCourses(){
        this.reportDao = new ReportDao();
        List<Course> courseList = reportDao.getPublicCourse();
        assertThat(courseList)
                .hasSize(2)
                .extracting(Course::getUrlCode)
                .contains("java-jpa-consultas-avancadas-performance-modelos-complexos", "java-primeiros-passos");

    }

    @Test
    void shouldReturnListSubCategoryWithDescriptionNullOrEmpty(){
        this.reportDao = new ReportDao();
        List<SubCategory> subCategoryList = reportDao.getSubCategoryDescriptionNull();
        assertThat(subCategoryList)
                .hasSize(2)
                .extracting(SubCategory::getUrlCode)
                .contains("java-e-persistencia", "cobol");
    }


}
