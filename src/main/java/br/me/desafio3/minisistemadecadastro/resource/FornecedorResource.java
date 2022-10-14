package br.me.desafio3.minisistemadecadastro.resource;

import br.me.desafio3.minisistemadecadastro.models.Fornecedor;
import br.me.desafio3.minisistemadecadastro.services.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping(value="/fornecedores")
public class FornecedorResource {
    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping
public ResponseEntity<List<Fornecedor>> findAll(){
        List<Fornecedor> fornecedores = fornecedorService.findAll();
        return ResponseEntity.ok().body(fornecedores);
    }


}
