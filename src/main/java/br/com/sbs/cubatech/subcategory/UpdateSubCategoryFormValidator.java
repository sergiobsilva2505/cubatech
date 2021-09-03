package br.com.sbs.cubatech.subcategory;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@AllArgsConstructor
@Component
public class UpdateSubCategoryFormValidator implements Validator {

    private final SubCategoryRepository subCategoryRepository;

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
