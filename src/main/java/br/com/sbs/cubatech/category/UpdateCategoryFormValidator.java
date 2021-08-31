package br.com.sbs.cubatech.category;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UpdateCategoryFormValidator implements Validator {

    private final CategoryRepository categoryRepository;

    public UpdateCategoryFormValidator(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return UpdateCategoryForm.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UpdateCategoryForm form = (UpdateCategoryForm) target;
        if(categoryRepository.existsByUrlCodeWithDifferentId(form.getUrlCode(), form.getId())){
            errors.rejectValue("urlCode", "category.urlCode.already.exists");
        }
    }
}
