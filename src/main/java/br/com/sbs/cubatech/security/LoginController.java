package br.com.sbs.cubatech.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showFormLogin(){
        return "/login";
    }
}
