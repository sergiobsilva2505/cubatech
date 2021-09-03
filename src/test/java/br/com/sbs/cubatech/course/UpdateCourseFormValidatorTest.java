package br.com.sbs.cubatech.course;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.validation.Errors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.never;

class UpdateCourseFormValidatorTest {

    private CourseRepository courseRepository;
    private UpdateCourseFormValidator updateCourseFormValidator;
    private Errors errors;

    @BeforeEach
    void setUp() {
        courseRepository = mock(CourseRepository.class);
        updateCourseFormValidator = new UpdateCourseFormValidator(courseRepository);
        errors = mock(Errors.class);
    }

    @Test
    void validate__should_return_error_when_urlcode_already_exists() {
        UpdateCourseForm form = mock(UpdateCourseForm.class);

        when(courseRepository.existsByUrlCodeWithDifferentId(form.getUrlCode(), form.getId())).thenReturn(true);

        updateCourseFormValidator.validate(form, errors);

        verify(errors).rejectValue("urlCode", "course.urlCode.already.exists");
    }

    @Test
    void validate__should_not_return_error_when_urlcode_does_not_exist() {
        UpdateCourseForm form = mock(UpdateCourseForm.class);

        when(courseRepository.existsByUrlCodeWithDifferentId(form.getUrlCode(), form.getId())).thenReturn(false);

        updateCourseFormValidator.validate(form, errors);

        verify(errors, never()).rejectValue("urlCode", "course.urlCode.already.exists");
    }

}