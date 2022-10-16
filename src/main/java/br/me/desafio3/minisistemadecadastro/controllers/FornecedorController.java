package br.me.desafio3.minisistemadecadastro.controllers;

import br.me.desafio3.minisistemadecadastro.models.Fornecedor;
import br.me.desafio3.minisistemadecadastro.services.FornecedorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value="/fornecedores")
public class FornecedorController {
    @Autowired
    private FornecedorService fornecedorService;

    @RequestMapping(method= RequestMethod.GET)
    public ResponseEntity<List<Fornecedor>> findAll() {
        List<Fornecedor> list = fornecedorService.findAll();
        List<Fornecedor> listaFornecedor = list.stream().map(x -> new Fornecedor(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listaFornecedor);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<Fornecedor> findById(@PathVariable String id) {
        Fornecedor obj = fornecedorService.findById(id);
        return ResponseEntity.ok().body(new Fornecedor(obj));
    }

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody Fornecedor obj) {
        Fornecedor fornecedor = fornecedorService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable String id) {
        fornecedorService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody Fornecedor obj, @PathVariable String id) {
        Fornecedor fornecedor = fornecedorService.update(obj);
        obj.setId(id);

        return ResponseEntity.noContent().build();
    }

}
