package br.com.sbs.cubatech.security;

import br.com.sbs.cubatech.category.Category;
import br.com.sbs.cubatech.category.CategoryRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class LoginController {

    private AuthenticationService authenticationService;
    private CategoryRepository categoryRepository;

    public LoginController(AuthenticationService authenticationService, CategoryRepository categoryRepository) {
        this.authenticationService = authenticationService;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/login")
    public String showFormLogin(Model model){
        List<Category> categories = categoryRepository.findActiveCategoriesWithActiveSubCategoriesAndPublicCourses();
        model.addAttribute("categories", categories);
        return "/login";
    }

    public void login(LoginForm loginForm){
       authenticationService.loadUserByUsername(loginForm.getEmail());
    }
}
