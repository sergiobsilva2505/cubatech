package br.com.sbs.cubatech.category;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CategoryController {

    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/admin/categories")
    public String getAll(Model model) {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryDto> categoryDtos = CategoryDto.convertAll(categories);
        model.addAttribute("categories", categoryDtos);
        return "category/viewCategoryList";
    }

    @GetMapping("/admin/categories/new")
    public String formAddCategory(Model model){
        model.addAttribute("statusValues", Status.values());
        return "category/formNewCategory";
    }

    @PostMapping("/admin/categories")
    @CacheEvict(value = "categories", allEntries = true)
    public String newCategory(@Valid CategoryForm categoryForm, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()) {
            return formAddCategory(model);
        }
        Category category = categoryForm.toEntity();
        categoryRepository.save(category);
        return "redirect:/admin/categories";
    }

    @GetMapping("/admin/categories/{urlCode}")
    public String showCategory(@PathVariable String urlCode, Model model){
        Category category = categoryRepository.findByUrlCode(urlCode)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, urlCode));
        model.addAttribute("category", new CategoryDto(category));
        model.addAttribute("statusValues", Status.values());
        return "category/formUpdateCategory";
    }

    @PostMapping("/admin/categories/{urlCode}")
    @CacheEvict(value = "categories", allEntries = true)
    public String editCategory(@PathVariable String urlCode, @Valid CategoryForm categoryForm, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()) {
            return showCategory(urlCode, model);
        }
        Category category = categoryForm.toEntity();
        categoryRepository.save(category);
        return "redirect:/admin/categories";
    }

    @GetMapping("/admin/subcategories")
    public String getAllSubcategories(){
        return "subCategory/viewSubCategoryList";
    }
}
