package br.com.sbs.cubatech.course;

import br.com.sbs.cubatech.util.ProgramingDatabaseMotherTest;
import br.com.sbs.cubatech.category.CategoryRepository;
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
class CourseRepositoryTest {

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
    void shouldReturnTheNameOfAnInstructorWithMoreCoursesAndTheNumberOfCourses() {
        List<CourseProjection> instructor = courseRepository.findInstructorWithMoreCourses();
        assertThat(instructor.size()).isEqualTo(1);
        assertEquals(instructor.get(0).getInstructor(), "Paulo Silvaira");
        assertThat(instructor.get(0).getQuantityOfCourses()).isEqualTo(3);
        // todo assert that

    }

//    Page<Course> findAllBySubCategory(SubCategory subCategory, Pageable pageable);
    // todo teste

    @Test
    void shouldReturnAnEmptyOptionalInUrlCode(){
        String courseUrlCode = "businnes";
        Optional<Course> course = courseRepository.findByUrlCode(courseUrlCode);

        assertTrue(course.isEmpty());
    }

    @Test
    void shouldReturnAnCourseByUrlCode(){
        String courseUrlCode = "java-primeiros-passos";
        Optional<Course> course = courseRepository.findByUrlCode(courseUrlCode);

        assertTrue(course.isPresent());
        assertEquals("java-primeiros-passos", course.get().getUrlCode());
    }
}