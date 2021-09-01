package br.com.sbs.cubatech.subcategory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.validation.Errors;

import static org.mockito.Mockito.*;

class UpdateSubCategoryFormValidatorTest {

    private SubCategoryRepository subCategoryRepository;
    private UpdateSubCategoryFormValidator updateSubCategoryFormValidator;
    private Errors errors;

    @BeforeEach
    void setUp() {
        subCategoryRepository = mock(SubCategoryRepository.class);
        updateSubCategoryFormValidator = new UpdateSubCategoryFormValidator(subCategoryRepository);
        errors = mock(Errors.class);
    }

    @Test
    void validate__should_return_error_when_urlcode_already_exists() {
        UpdateSubCategoryForm form = new UpdateSubCategoryForm();
        when(subCategoryRepository.existsByUrlCodeWithDifferentId(form.getUrlCode(), form.getId())).thenReturn(true);

        updateSubCategoryFormValidator.validate(form, errors);

        verify(errors).rejectValue("urlCode", "subcategory.urlCode.already.exists");
    }

    @Test
    void validate__should_not_return_error_when_urlcode_does_not_exist() {
        UpdateSubCategoryForm form = new UpdateSubCategoryForm();
        when(subCategoryRepository.existsByUrlCodeWithDifferentId(form.getUrlCode(), form.getId())).thenReturn(false);

        updateSubCategoryFormValidator.validate(form, errors);

        verify(errors, never()).rejectValue("urlCode", "subcategory.urlCode.already.exists");
    }
}