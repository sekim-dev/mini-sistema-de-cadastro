package br.me.desafio3.minisistemadecadastro.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @GetMapping("/cadastro")
    public String index(Model model){
        model.addAttribute("msnBemVindo", "Bem-vindo a biblioteca");
        return "/cadastro-index";
    }
}
