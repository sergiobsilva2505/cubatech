package br.com.sbs.cubatech.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

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
    public String addCategory(Model model){
        System.out.println("addCategories");
        return "formNovaCategoria";
    }

    @GetMapping("/admin/categories/{categoryCode}")
    public String editCategory(Model model){
        System.out.println("pagina edita categoria");
        return "formAlteraCategoria";
    }
}
