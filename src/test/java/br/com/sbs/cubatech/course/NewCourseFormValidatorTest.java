package br.com.sbs.cubatech.course;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.validation.Errors;

import static org.mockito.Mockito.*;

class NewCourseFormValidatorTest {
    
    private CourseRepository courseRepository;
    private NewCourseFormValidator newCourseFormValidator;
    private Errors errors;

    @BeforeEach
    void setUp() {
        courseRepository = mock(CourseRepository.class);
        newCourseFormValidator = new NewCourseFormValidator(courseRepository);
        errors = mock(Errors.class);
    }

    @Test
    void validate__should_return_error_when_urlcode_already_exists() {
        NewCourseForm form = new NewCourseForm();

        when(courseRepository.existsByUrlCode(form.getUrlCode())).thenReturn(true);

        newCourseFormValidator.validate(form, errors);

        verify(errors).rejectValue("urlCode", "course.urlCode.already.exists");
    }

    @Test
    void validate__should_not_return_error_when_urlcode_does_not_exist() {
        NewCourseForm form = new NewCourseForm();

        when(courseRepository.existsByUrlCode(form.getUrlCode())).thenReturn(false);

        newCourseFormValidator.validate(form, errors);

        verify(errors, never()).rejectValue("urlCode", "course.urlCode.already.exists");
    }
}