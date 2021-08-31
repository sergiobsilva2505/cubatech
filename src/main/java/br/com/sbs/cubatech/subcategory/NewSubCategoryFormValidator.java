package br.com.sbs.cubatech.subcategory;

import br.com.sbs.cubatech.category.NewCategoryForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class NewSubCategoryFormValidator implements Validator {

    private final SubCategoryRepository subCategoryRepository;

    public NewSubCategoryFormValidator(SubCategoryRepository subCategoryRepository) {
        this.subCategoryRepository = subCategoryRepository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return NewSubCategoryForm.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        NewSubCategoryForm form = (NewSubCategoryForm) target;
        if (subCategoryRepository.existsByUrlCode(form.getUrlCode())){
            errors.rejectValue("urlCode", "subcategory.urlCode.already.exists");
        }
    }
}
