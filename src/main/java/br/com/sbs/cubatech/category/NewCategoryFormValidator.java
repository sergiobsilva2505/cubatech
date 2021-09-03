package br.com.sbs.cubatech.category;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class NewCategoryFormValidator implements Validator {

    private final CategoryRepository categoryRepository;

    public NewCategoryFormValidator(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return NewCategoryForm.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        NewCategoryForm form = (NewCategoryForm) target;
        if(categoryRepository.existsByUrlCode(form.getUrlCode())){
            errors.rejectValue("urlCode", "category.urlCode.already.exists");
        }
    }
}
