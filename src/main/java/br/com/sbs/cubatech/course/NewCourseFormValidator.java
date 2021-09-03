package br.com.sbs.cubatech.course;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class NewCourseFormValidator implements Validator {

    private CourseRepository courseRepository;

    public NewCourseFormValidator(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return NewCourseForm.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        NewCourseForm form = (NewCourseForm) target;
        if (courseRepository.existsByUrlCode(form.getUrlCode())){
            errors.rejectValue("urlCode", "course.urlCode.already.exists");
        }
    }
}
