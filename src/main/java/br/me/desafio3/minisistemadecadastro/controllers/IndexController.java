package br.me.desafio3.minisistemadecadastro.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("msnBemVindo", "Bem-vindo ao mini sistema de cadastro");
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
