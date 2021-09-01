package br.com.sbs.cubatech.category;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.validation.Errors;

import static org.mockito.Mockito.*;

class UpdateCategoryFormValidatorTest {

    private CategoryRepository categoryRepository;
    private UpdateCategoryFormValidator updateCategoryFormValidator;
    private Errors errors;

    @BeforeEach
    void setUp() {
        categoryRepository = mock(CategoryRepository.class);
        updateCategoryFormValidator = new UpdateCategoryFormValidator(categoryRepository);
        errors = mock(Errors.class);
    }

    @Test
    void validate__should_return_error_when_category_urlcode_already_exists() {
        UpdateCategoryForm form = new UpdateCategoryForm();

        when(categoryRepository.existsByUrlCodeWithDifferentId(form.getUrlCode(), form.getId())).thenReturn(true);

        updateCategoryFormValidator.validate(form, errors);

        verify(errors).rejectValue("urlCode", "category.urlCode.already.exists");
    }

    @Test
    void validate__should_not_return_error_when_category_urlcode_not_exists() {
        UpdateCategoryForm form = new UpdateCategoryForm();

        when(categoryRepository.existsByUrlCodeWithDifferentId(form.getUrlCode(), form.getId())).thenReturn(false);

        updateCategoryFormValidator.validate(form, errors);

        verify(errors, never()).rejectValue("urlCode", "category.urlCode.already.exists");
    }
}