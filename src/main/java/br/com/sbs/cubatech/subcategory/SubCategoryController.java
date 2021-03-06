package br.com.sbs.cubatech.subcategory;

import br.com.sbs.cubatech.category.Category;
import br.com.sbs.cubatech.category.CategoryRepository;
import br.com.sbs.cubatech.category.Status;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@Controller
public class SubCategoryController {

    private final SubCategoryRepository subCategoryRepository;
    private final CategoryRepository categoryRepository;
    private final NewSubCategoryFormValidator newSubCategoryFormValidator;
    private final UpdateSubCategoryFormValidator updateSubCategoryFormValidator;

    @InitBinder("newSubCategoryForm")
    void initBinderNewSubCategoryForm(WebDataBinder webDataBinder){
        webDataBinder.addValidators(newSubCategoryFormValidator);
    }

    @InitBinder("updateSubCategoryForm")
    void initBinderUpdateSubCategoryForm(WebDataBinder webDataBinder){
        webDataBinder.addValidators(updateSubCategoryFormValidator);
    }

    @GetMapping("/admin/subcategories/{categoryCode}")
    public String getAll(@PathVariable String categoryCode, Model model) {
        Category category = categoryRepository.findByUrlCode(categoryCode)
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, categoryCode));
        List<SubCategory> subCategories = category.getSubCategories();
        List<SubCategoryDto> subCategoriesDtos = SubCategoryDto.convertAll(subCategories);
        model.addAttribute("subCategories", subCategoriesDtos);
        model.addAttribute("category", category);
        return "subCategory/viewSubCategoryList";
    }

    @GetMapping("/admin/subcategories/new")
    public String formAddSubCategory(Model model){
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("statusValues", Status.values());
        model.addAttribute("categories", categories);
        return "subCategory/formNewSubCategory";
    }

    @PostMapping("/admin/subcategories")
    public String newSubCategory(@Valid NewSubCategoryForm newSubCategoryForm, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()) {
            return formAddSubCategory(model);
        }
        Category category = categoryRepository.findById(newSubCategoryForm.getCategoryId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST)) ;
        SubCategory subCategory = newSubCategoryForm.toEntity(category);
        subCategoryRepository.save(subCategory);
        return "redirect:/admin/subcategories/" + subCategory.getCategory().getUrlCode();
    }

    @GetMapping("/admin/subcategories/{categoryCode}/{subCategoryCode}")
    public String showSubCategory(@PathVariable String categoryCode, @PathVariable String subCategoryCode, Model model){
        List<Category> categories = categoryRepository.findAll();
        SubCategory subCategory = subCategoryRepository.findByUrlCode(subCategoryCode)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST));
        Category category = categoryRepository.findByUrlCode(categoryCode)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST));
        model.addAttribute("category", category);
        model.addAttribute("statusValues", Status.values());
        model.addAttribute("categories", categories);
        model.addAttribute("subCategory", new SubCategoryDto(subCategory));
        return "subCategory/formUpdateSubCategory";
    }

    @PostMapping("/admin/subcategories/{categoryCode}/{subCategoryCode}")
    public String editSubCategory(@PathVariable String categoryCode,
                                  @PathVariable String subCategoryCode,
                                  @Valid UpdateSubCategoryForm updateSubCategoryForm,
                                  BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()) {
            return showSubCategory(categoryCode, subCategoryCode, model);
        }
        Category category = categoryRepository.findById(updateSubCategoryForm.getCategoryId())
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST));
        SubCategory subCategory = subCategoryRepository.findByUrlCode(subCategoryCode).orElseThrow(()->new ResponseStatusException(HttpStatus.BAD_REQUEST));
        subCategory.update(updateSubCategoryForm, category);
        subCategoryRepository.save(subCategory);
        return "redirect:/admin/subcategories/"+ subCategory.getCategory().getUrlCode();
    }
}
