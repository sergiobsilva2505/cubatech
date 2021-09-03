package br.com.sbs.cubatech.security;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class LoginForm {

    private final String email;
    private final String password;

}
