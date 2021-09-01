package br.com.sbs.cubatech.category;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.validation.Errors;

import static org.mockito.Mockito.*;

class NewCategoryFormValidatorTest {
    
    private CategoryRepository categoryRepository;
    private NewCategoryFormValidator newCategoryFormValidator;
    private Errors errors;

    @BeforeEach
    void setUp() {
        categoryRepository = mock(CategoryRepository.class);
        newCategoryFormValidator = new NewCategoryFormValidator(categoryRepository);
        errors = mock(Errors.class);
    }

    @Test
    void validate__should_return_error_when_category_urlcode_already_exists() {
        NewCategoryForm form = new NewCategoryForm();
        when(categoryRepository.existsByUrlCode(form.getUrlCode())).thenReturn(true);

        newCategoryFormValidator.validate(form, errors);

        verify(errors).rejectValue("urlCode", "category.urlCode.already.exists");
    }

    @Test
    void validate__should_not_give_error_when_urlcode_does_not_exist() {
        NewCategoryForm form = new NewCategoryForm();
        when(categoryRepository.existsByUrlCode(form.getUrlCode())).thenReturn(false);

        newCategoryFormValidator.validate(form, errors);

        verify(errors, never()).rejectValue("urlCode", "category.urlCode.already.exists");

    }
}