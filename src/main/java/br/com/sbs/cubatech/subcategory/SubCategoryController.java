package br.com.sbs.cubatech.subcategory;

import br.com.sbs.cubatech.category.Category;
import br.com.sbs.cubatech.category.CategoryRepository;
import br.com.sbs.cubatech.category.Status;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Controller
public class SubCategoryController {

    public final SubCategoryRepository subCategoryRepository;
    public final CategoryRepository categoryRepository;

    public SubCategoryController(SubCategoryRepository subCategoryRepository, CategoryRepository categoryRepository){
        this.subCategoryRepository = subCategoryRepository;
        this.categoryRepository = categoryRepository;
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
    public String newSubCategory(SubCategoryForm subCategoryForm, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()) {
            return formAddSubCategory(model);
        }
        Category category = categoryRepository.findById(subCategoryForm.getCategoryId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST)) ;
        SubCategory subCategory = subCategoryForm.toEntity(category);
        subCategoryRepository.save(subCategory);
        return "redirect:/admin/subcategories/"+subCategory.getCategory().getUrlCode();
    }
}
