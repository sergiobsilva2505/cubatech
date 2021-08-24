package br.com.sbs.cubatech.category;

import br.com.sbs.cubatech.util.ProgramingDatabaseMotherTest;
import br.com.sbs.cubatech.course.CourseRepository;
import br.com.sbs.cubatech.subcategory.SubCategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
    void shouldReturnAListOfCategoriesByStatusActive(){
        List<Category> categoriesActive = categoryRepository.findByStatus(Status.ACTIVE);

        assertThat(categoriesActive)
                .extracting(Category::getStatus)
                .contains(Status.ACTIVE);
    }

    @Test
    void shouldReturnAListOfCategoriesByStatusInactive(){
        List<Category> categoriesInactive = categoryRepository.findByStatus(Status.INACTIVE);

        assertThat(categoriesInactive)
                .extracting(Category::getStatus)
                .contains(Status.INACTIVE);
    }

    @Test
    void shouldReturnACategoryByUrlCode() {
        String categoryUrlCode = "devops";
        Optional<Category> category = categoryRepository.findByUrlCode(categoryUrlCode);

        assertTrue(category.isPresent());
        assertEquals("devops", category.get().getUrlCode());
    }

    @Test
    void shouldReturnAnEmptyOptional(){
        String categoryUrlCode = "data-science";
        Optional<Category> category = categoryRepository.findByUrlCode(categoryUrlCode);

        assertTrue(category.isEmpty());
    }

    @Test
    void shouldReturnTheNameOfACategoryAndTheNumberOfCourses() {
        List<CategoryProjection> categories = categoryRepository.findCategoriesQuantityOfCourses();
        assertThat(categories.size()).isEqualTo(3);
        assertThat(categories.get(0).getQuantityOfCourses()).isEqualTo(4);
        assertEquals(categories.get(0).getName(), "Programação");
        assertEquals(categories.get(2).getName(), "Business");
        assertThat(categories.get(1).getQuantityOfCourses()).isEqualTo(1);
        assertEquals(categories.get(1).getName(), "DevOps");

    }
}