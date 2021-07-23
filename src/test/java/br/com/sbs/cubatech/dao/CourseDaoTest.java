package br.com.sbs.cubatech.dao;

import br.com.sbs.cubatech.builder.CategoryBuilder;
import br.com.sbs.cubatech.builder.CourseBuilder;
import br.com.sbs.cubatech.builder.SubCategoryBuilder;
import br.com.sbs.cubatech.category.Category;
import br.com.sbs.cubatech.category.SubCategory;
import br.com.sbs.cubatech.course.Course;
import br.com.sbs.cubatech.course.CourseDao;
import br.com.sbs.cubatech.util.JPAUtilTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CourseDaoTest {

    private EntityManager entityManager;

    private CourseDao courseDao;
    private Category category;
    private  SubCategory subCategory;

    @BeforeEach
    void setUp() {
        this.entityManager = JPAUtilTest.getEntityManager();
        this.courseDao = new CourseDao(entityManager);
        entityManager.getTransaction().begin();
        this.category = aCategoryActive("Programação", "programacao");
        this.subCategory = aSubCategoryActive("Java", "java", category);
    }

    @AfterEach
    void tearDown() {
        this.entityManager.getTransaction().rollback();
    }

    @Test
    void shouldReturnCourseListWithAllPublicCourses(){
        aCoursePublic("Java e jpa", "java-jpa-consultas-avancadas-performance-modelos-complexos", 8, "Gesley Elois", subCategory);
        aCoursePublic("Java primeiros passos", "java-primeiros-passos", 12, "Cadu", subCategory);
        aCoursePrivate("PHP", "php", 10, "Fabio", subCategory);
        List<Course> courseList = courseDao.getPublicCourse();
        assertThat(courseList)
                .hasSize(2)
                .extracting(Course::getUrlCode)
                .contains("java-jpa-consultas-avancadas-performance-modelos-complexos", "java-primeiros-passos");

    }

    private void aCoursePublic(String name, String urlCode, Integer timeToFinishInHours, String instructor, SubCategory subCategory){
        Course course = new CourseBuilder(name, urlCode, timeToFinishInHours, instructor, subCategory)
                .isPublic()
                .build();
        entityManager.persist(course);
    }

    private void aCoursePrivate(String name, String urlCode, Integer timeToFinishInHours, String instructor, SubCategory subCategory){
        Course course = new CourseBuilder(name, urlCode, timeToFinishInHours, instructor, subCategory)
                .isPrivate()
                .build();
        entityManager.persist(course);
    }

    private SubCategory aSubCategoryActive(String name, String urlCode, Category category){
        SubCategory subCategory = new SubCategoryBuilder(name, urlCode, category).active().build();
        entityManager.persist(subCategory);
        return  subCategory;
    }

    private Category aCategoryActive(String name, String urlCode){
        Category category = new CategoryBuilder(name, urlCode)
                .active()
                .build();
        entityManager.persist(category);
        return category;
    }
}
