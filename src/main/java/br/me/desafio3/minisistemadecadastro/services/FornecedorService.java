package br.me.desafio3.minisistemadecadastro.services;

import br.me.desafio3.minisistemadecadastro.models.Fornecedor;
import br.me.desafio3.minisistemadecadastro.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FornecedorService {
    @Autowired
    private FornecedorRepository fornecedorRepo;

    public List<Fornecedor> findAll(){
        return fornecedorRepo.findAll();
    }

}
