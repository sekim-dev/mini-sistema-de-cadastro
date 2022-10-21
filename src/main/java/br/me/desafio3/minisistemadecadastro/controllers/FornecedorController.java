package br.me.desafio3.minisistemadecadastro.controllers;

import br.me.desafio3.minisistemadecadastro.models.Fornecedor;
import br.me.desafio3.minisistemadecadastro.repository.FornecedorRepository;
import br.me.desafio3.minisistemadecadastro.services.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping(value = "/fornecedor")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;
    @Autowired
    private FornecedorRepository fornecedorRepository;

    @GetMapping("/novo")
    public String adicionarFornecedor(Model model) {
        model.addAttribute("fornecedor", new Fornecedor());
        return "/cadastro-fornecedor";
    }

    @PostMapping("/salvar")
    public String salvarFornecedor(Fornecedor fornecedor, RedirectAttributes attributes) {
        fornecedorService.insert(fornecedor);
        attributes.addFlashAttribute("mensagem", "Fornecedor salvo com sucesso!");
        return "redirect:/fornecedor/novo";
    }

    @RequestMapping("/fornecedor/listar")
    public String listarFornecedor(Model model) {
        List<Fornecedor> lista = fornecedorService.listarFornecedor();
        model.addAttribute("fornecedor", lista);
        return "/auth/admin/admin-listar-fornecedor";
    }

    @GetMapping("/fornecedor/apagar/{id}")
    public String deleteFornecedor(@PathVariable("id") String id, Model model) {
        fornecedorService.apagarFornecedorPorId(id);
        return "redirect:/fornecedor/admin/listar";
    }

    @GetMapping("/editar/{id}")
    public String editarFornecedor(@PathVariable("id") String id, Model model, Fornecedor fornecedor) {
        fornecedorService.alterarFornecedor(fornecedor);
        return "redirect:/fornecedor/admin/listar";


    }
}




