package br.com.sbs.cubatech.subcategory;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UpdateSubCategoryFormValidator implements Validator {

    private final SubCategoryRepository subCategoryRepository;

    public UpdateSubCategoryFormValidator(SubCategoryRepository subCategoryRepository) {
        this.subCategoryRepository = subCategoryRepository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return UpdateSubCategoryForm.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UpdateSubCategoryForm form = (UpdateSubCategoryForm) target;
        if (subCategoryRepository.existsByUrlCodeWithDifferentId(form.getUrlCode(), form.getId())){
            errors.rejectValue("urlCode", "subcategory.urlCode.already.exists");
        }
    }
}
