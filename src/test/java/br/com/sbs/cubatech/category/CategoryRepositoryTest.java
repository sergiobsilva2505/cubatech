package br.com.sbs.cubatech.category;

import br.com.sbs.cubatech.course.Course;
import br.com.sbs.cubatech.course.CourseRepository;
import br.com.sbs.cubatech.course.CourseVisibility;
import br.com.sbs.cubatech.subcategory.SubCategory;
import br.com.sbs.cubatech.subcategory.SubCategoryRepository;
import br.com.sbs.cubatech.util.ProgramingDatabaseMotherTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private SubCategoryRepository subCategoryRepository;
    @Autowired
    private CourseRepository courseRepository;

    @BeforeEach
    void init(){
        ProgramingDatabaseMotherTest programingDatabaseMotherTest = new ProgramingDatabaseMotherTest(categoryRepository, subCategoryRepository, courseRepository);
        programingDatabaseMotherTest.create();
    }

    @Test
    void findByStatus__should_return_a_list_of_categories_by_status_active(){
        List<Category> categoriesActive = categoryRepository.findByStatus(Status.ACTIVE);

        assertThat(categoriesActive)
                .extracting(Category::getStatus)
                .contains(Status.ACTIVE);
    }

    @Test
    void findByStatus__should_return_a_list_of_categories_by_status_inactive(){
        List<Category> categoriesInactive = categoryRepository.findByStatus(Status.INACTIVE);

        assertThat(categoriesInactive)
                .extracting(Category::getStatus)
                .contains(Status.INACTIVE);
    }

    @Test
    void findByUrlCode__should_return_a_category_by_urlCode() {
        String categoryUrlCode = "devops";
        Optional<Category> category = categoryRepository.findByUrlCode(categoryUrlCode);
        assertThat(category.isPresent());
        assertThat(category.get()).extracting(Category::getUrlCode).isEqualTo(categoryUrlCode);
    }

    @Test
    void findByUrlCode__should_return_an_empty_optional(){
        String categoryUrlCode = "data-science";
        Optional<Category> category = categoryRepository.findByUrlCode(categoryUrlCode);

        assertThat(category.isEmpty()).isTrue();
    }

    @Test
    void findCategoriesQuantityOfCourses__should_return_the_name_of_a_category_and_the_number_of_courses() {
        List<CategoryProjection> categories = categoryRepository.findCategoriesQuantityOfCourses();

        assertThat(categories.size()).isEqualTo(3);
        assertThat(categories.get(0).getQuantityOfCourses()).isEqualTo(4);
        assertThat(categories.get(0).getName()).isEqualTo("Programação");
        assertThat(categories.get(2).getName()).isEqualTo("Business");
        assertThat(categories.get(1).getQuantityOfCourses()).isEqualTo(1);
        assertThat(categories.get(1).getName()).isEqualTo("DevOps");
    }

    @Test
    void findActiveCategoriesWithActiveSubCategoriesAndPublicCourses__should(){
        List<Category> categories = categoryRepository.findActiveCategoriesWithActiveSubCategoriesAndPublicCourses();

        assertThat(categories)
                .hasSize(2)
                .extracting(Category::getStatus)
                .contains(Status.ACTIVE);
        assertThat(categories)
                .extracting(Category::getUrlCode)
                .containsExactlyInAnyOrder("programacao", "devops");

        List<SubCategory> subCategoriesIndex0 = categories.get(0).getSubCategories();
        assertThat(subCategoriesIndex0)
                .hasSize(4)
                .extracting(SubCategory::getStatus)
                .contains(Status.ACTIVE);
        assertThat(subCategoriesIndex0)
                .extracting(SubCategory::getUrlCode)
                .containsExactlyInAnyOrder("java", "java-e-persistencia", "php", "cobol");

        List<SubCategory> subCategoriesIndex1 = categories.get(1).getSubCategories();
        assertThat(subCategoriesIndex1)
                .hasSize(1)
                .extracting(SubCategory::getStatus)
                .contains(Status.ACTIVE);
        assertThat(subCategoriesIndex1)
                .extracting(SubCategory::getUrlCode)
                .containsExactlyInAnyOrder("builds-e-controle-de-versao");

        List<Course> coursesIndex0 = subCategoriesIndex0.get(0).getCourses();
        assertThat(coursesIndex0)
                .hasSize(3)
                .extracting(Course::getCourseVisibility)
                .contains(CourseVisibility.PUBLIC);
        assertThat(coursesIndex0)
                .extracting(Course::getUrlCode)
                .containsExactlyInAnyOrder("angular-cli", "java-introducao-orientacao-objetos", "java-primeiros-passos");

        List<Course> coursesIndex1 = subCategoriesIndex0.get(1).getCourses();
        assertThat(coursesIndex1)
                .hasSize(1)
                .extracting(Course::getCourseVisibility)
                .contains(CourseVisibility.PUBLIC);
        assertThat(coursesIndex1)
                .extracting(Course::getUrlCode)
                .containsExactlyInAnyOrder("java-jpa-consultas-avancadas-performance-modelos-complexos");

    }
}