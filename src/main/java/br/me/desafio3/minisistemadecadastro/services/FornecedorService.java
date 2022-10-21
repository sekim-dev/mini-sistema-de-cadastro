package br.me.desafio3.minisistemadecadastro.services;

import br.me.desafio3.minisistemadecadastro.models.Fornecedor;
import br.me.desafio3.minisistemadecadastro.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {
    @Autowired
    private FornecedorRepository fornecedorRepository;

//    public List<Fornecedor> findAll() {
//        return fornecedorRepository.findAll();
//    }


    public Fornecedor insert(Fornecedor obj) {
        return fornecedorRepository.insert(obj);
    }

    public List<Fornecedor> listarFornecedor() {
        List<Fornecedor> fornecedors = fornecedorRepository.findAll();
        return fornecedors;
    }

//    @Override
    public void apagarFornecedorPorId(String id) {
        Fornecedor fornecedor = buscarFornecedorPorId(id);
        fornecedorRepository.delete(fornecedor);
    }

//    @Override
    public Fornecedor buscarFornecedorPorId(String id) {
        Optional<Fornecedor> opt = fornecedorRepository.findById(id);
        if (opt.isPresent()) {
            return opt.get();
        } else {
            throw new IllegalArgumentException("Fornecedor com id : " + id + " não existe");
        }
    }




////    @Override
//    public Fornecedor gravarUsuario(Fornecedor fornecedor) {
//
//        String senhaCriptografia = criptografia.encode(fornecedor.getPassword());
//        fornecedor.setPassword(senhaCriptografia);
//
//        return fornecedorRepository.save(fornecedor);
//    }

//    @Override
    public void alterarFornecedor(Fornecedor fornecedor) {
        fornecedorRepository.save(fornecedor);
    }









}


