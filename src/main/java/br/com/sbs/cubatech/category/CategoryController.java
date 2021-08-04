package br.com.sbs.cubatech.category;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/admin/categories")
    public String getAll(Model model) {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryDto> categoryDtos = CategoryDto.convertAll(categories);
        model.addAttribute("categories", categoryDtos);
        return "listaCategorias";
    }

    @GetMapping("/admin/categories/new")
    public String formAddCategory(Model model){
        model.addAttribute("statusValues", Status.values());
        return "formNovaCategoria";
    }

    @PostMapping("/admin/categories")
    public String newCategory(@Valid CategoryForm categoryForm, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()) {
            return formAddCategory(model);
        }
        Category category = CategoryForm.toEntity(categoryForm);
        categoryRepository.save(category);
        return "redirect:/admin/categories";
    }

    @GetMapping("/admin/categories/{urlCode}")
    public String showCategory(@PathVariable String urlCode, Model model){
        Category category = categoryRepository.findByUrlCode(urlCode)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, urlCode));
        model.addAttribute("category", new CategoryDto(category));
        model.addAttribute("statusValues", Status.values());
        return "formAlteraCategoria";
    }

    @PostMapping("/admin/categories/{urlCode}")
    public String editCategory(@PathVariable String urlCode, @Valid UpdateCategoryForm updateCategoryForm, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()) {
            return showCategory(urlCode, model);
        }
        Category category = UpdateCategoryForm.toEntity(updateCategoryForm);
        categoryRepository.save(category);
        return "redirect:/admin/categories";
    }

    @GetMapping("/admin/subcategories")
    public String getAllSubcategories(){
        return "listaSubCategorias";
    }
}
