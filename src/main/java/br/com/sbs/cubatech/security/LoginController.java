package br.com.sbs.cubatech.security;

import br.com.sbs.cubatech.category.Category;
import br.com.sbs.cubatech.category.CategoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class LoginController {

    private UserRepository userRepository;
    private AuthenticationService authenticationService;
    private CategoryRepository categoryRepository;

    public LoginController(UserRepository userRepository, AuthenticationService authenticationService, CategoryRepository categoryRepository) {
        this.userRepository = userRepository;
        this.authenticationService = authenticationService;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/login")
    public String showFormLogin(Model model){
        List<Category> categories = categoryRepository.findCategories();
        model.addAttribute("categories", categories);
        return "/login";
    }

    @PostMapping("/login")
    public void login(LoginForm loginForm){
       authenticationService.loadUserByUsername(loginForm.getEmail());
    }
}
