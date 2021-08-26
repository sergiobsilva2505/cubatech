package br.com.sbs.cubatech.subcategory;

import br.com.sbs.cubatech.category.Category;
import br.com.sbs.cubatech.category.CategoryRepository;
import br.com.sbs.cubatech.course.CourseRepository;
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
class SubCategoryRepositoryTest {

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
    void shouldReturnAnEmptyOptionalInUrlCodeSearch(){
        String subCategoryUrlCode = "business";
        Optional<SubCategory> subCategory = subCategoryRepository.findByUrlCode(subCategoryUrlCode);

        assertThat(subCategory.isEmpty());
    }

    @Test
    void shouldReturnASubCategoryByUrlCode(){
        String subCategoryUrlCode = "java";
        Optional<SubCategory> subCategory = subCategoryRepository.findByUrlCode(subCategoryUrlCode);

        assertThat(subCategory.isPresent());
        assertThat(subCategory.get().getUrlCode()).isEqualTo("java");
    }

    @Test
    void shouldReturnTheActiveSubCategoriesOfACategory(){
        Optional<Category> category = categoryRepository.findByUrlCode("programacao");
        assertThat(category.isPresent());
        assertThat(category.get().getUrlCode()).isEqualTo("programacao");

        List<SubCategory> subCategories = subCategoryRepository.finAllActiveSubCategories(category.get());
        assertThat(subCategories)
                .hasSize(2)
                .extracting(SubCategory::getUrlCode)
                .containsExactlyInAnyOrder("java", "java-e-persistencia");
    }

}