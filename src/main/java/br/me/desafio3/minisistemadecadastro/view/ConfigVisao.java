package br.me.desafio3.minisistemadecadastro.view;

import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class ConfigVisao implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/auth/auth-acesso-negado").setViewName("/auth/auth-acesso-negado");
    }
}
