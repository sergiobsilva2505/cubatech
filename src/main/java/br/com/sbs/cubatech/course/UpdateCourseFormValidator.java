package br.com.sbs.cubatech.course;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UpdateCourseFormValidator implements Validator {

    private CourseRepository courseRepository;

    public UpdateCourseFormValidator(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return UpdateCourseForm.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UpdateCourseForm form = (UpdateCourseForm) target;
        if (courseRepository.existsByUrlCodeWithDifferentId(form.getUrlCode(), form.getId())){
            errors.rejectValue("urlCode", "course.urlCode.already.exists");
        }
    }
}
