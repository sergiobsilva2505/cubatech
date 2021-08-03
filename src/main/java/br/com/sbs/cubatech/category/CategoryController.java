package br.com.sbs.cubatech.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Controller
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/admin/categories")
    public String getAll(Model model) {
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);
        System.out.println("Executando a lógica com Spring MVC");
        return "listaCategorias";
    }

    @GetMapping("/admin/categories/new")
    public String formAddCategory(){
        return "formNovaCategoria";
    }

    @GetMapping("/admin/categories/{urlCode}")
    public String editCategory(@PathVariable String urlCode, Model model){
        Category category = categoryRepository.findByUrlCode(urlCode)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, urlCode));
        model.addAttribute("category", category);
        return "formAlteraCategoria";
    }

    @PostMapping("/admin/categories/{urlCode}")
    public String addCategory(Category category){
        categoryRepository.save(category);
        return "redirect:/admin/categories";
    }

    @GetMapping("/admin/subcategories")
    public String getAllSubcategories(){
        return "listaSubCategorias";
    }
}
