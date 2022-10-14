package br.me.desafio3.minisistemadecadastro.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetingController {

    @GetMapping("/olaMundo")
    public String olaMundo() {
        return "olaMundo";
    }

}