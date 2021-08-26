package br.com.sbs.cubatech.course;

import br.com.sbs.cubatech.category.CategoryRepository;
import br.com.sbs.cubatech.subcategory.SubCategory;
import br.com.sbs.cubatech.subcategory.SubCategoryRepository;
import br.com.sbs.cubatech.util.ProgramingDatabaseMotherTest;
import br.com.sbs.cubatech.util.builder.SubCategoryBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

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
    void findInstructorWithMoreCourses__should_return_the_name_of_an_instructor_with_more_courses_and_the_number_of_courses() {
        List<CourseProjection> instructor = courseRepository.findInstructorWithMoreCourses();

        assertThat(instructor.size()).isEqualTo(1);
        assertThat(instructor.get(0).getInstructor()).isEqualTo("Paulo Silvaira");
        assertThat(instructor.get(0).getQuantityOfCourses()).isEqualTo(3);
    }

    @Test
    void findAllBySubCategory__should_return_a_pageable_of_courses(){
        Optional<SubCategory> subCategory = subCategoryRepository.findByUrlCode("java");

        PageRequest pageable = PageRequest.of(0, 2);

        Page<Course> coursesBySubcategory = courseRepository.findAllBySubCategory(subCategory.get(), pageable);

        assertThat(coursesBySubcategory)
                .hasSize(2)
                .extracting(Course::getUrlCode)
                .containsExactlyInAnyOrder("java-primeiros-passos", "java-introducao-orientacao-objetos");
    }

    @Test
    void findAllBySubCategory__should_not_return_any_course_by_subcategory(){
        PageRequest pageable = PageRequest.of(0, 2);

        Page<Course> coursesBySubcategory = courseRepository.findAllBySubCategory(null, pageable);

        assertThat(coursesBySubcategory.isEmpty());

    }

    @Test
    void findByUrlCode__should_return_an_empty_optional_in_urlCode(){
        String courseUrlCode = "businnes";
        Optional<Course> course = courseRepository.findByUrlCode(courseUrlCode);

        assertThat(course.isEmpty());
    }

    @Test
    void findByUrlCode__should_return_an_course_by_urlCode(){
        String courseUrlCode = "java-primeiros-passos";
        Optional<Course> course = courseRepository.findByUrlCode(courseUrlCode);

        assertThat(course.isPresent());
        assertThat(course.get().getUrlCode()).isEqualTo("java-primeiros-passos");
    }
}