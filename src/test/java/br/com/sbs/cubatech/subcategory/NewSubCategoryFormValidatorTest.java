package br.com.sbs.cubatech.subcategory;

import br.com.sbs.cubatech.course.NewCourseFormValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.validation.Errors;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.never;

class NewSubCategoryFormValidatorTest {

    private SubCategoryRepository subCategoryRepository;
    private NewSubCategoryFormValidator newSubCategoryFormValidator;
    private Errors errors;

    @BeforeEach
    void setUp() {
        subCategoryRepository = mock(SubCategoryRepository.class);
        newSubCategoryFormValidator = new NewSubCategoryFormValidator(subCategoryRepository);
        errors = mock(Errors.class);
    }

    @Test
    void validate__should_return_error_when_urlcode_already_exists() {
        NewSubCategoryForm form = new NewSubCategoryForm();
        when(subCategoryRepository.existsByUrlCode(form.getUrlCode())).thenReturn(true);

        newSubCategoryFormValidator.validate(form, errors);

        verify(errors).rejectValue("urlCode", "subcategory.urlCode.already.exists");
    }

    @Test
    void validate__should_not_return_error_when_urlcode_does_not_exist() {
        NewSubCategoryForm form = new NewSubCategoryForm();
        when(subCategoryRepository.existsByUrlCode(form.getUrlCode())).thenReturn(false);

        newSubCategoryFormValidator.validate(form, errors);

        verify(errors, never()).rejectValue("urlCode", "subcategory.urlCode.already.exists");
    }

}