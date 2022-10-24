package br.me.desafio3.minisistemadecadastro.services;

import br.me.desafio3.minisistemadecadastro.models.Fornecedor;
import br.me.desafio3.minisistemadecadastro.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {
    @Autowired
    private FornecedorRepository fornecedorRepository;

    public List<Fornecedor> findAll() {
        return fornecedorRepository.findAll();
    }


    public Fornecedor insert(Fornecedor obj) {

        Fornecedor newFornecedor = new Fornecedor(
                obj.getNomeFornecedor(),
                obj.getNomeContato(),
                obj.getEmailContato(),
                obj.getCnpjCpf(),
                obj.getNumeroDocumento(),
                obj.getTelefoneLista(),
                obj.getEndereco(),
                obj.getDescricao()
        );
        if (obj.getId().isEmpty()) {
            return fornecedorRepository.save(newFornecedor);
        }
        newFornecedor.setId(obj.getId());
        return fornecedorRepository.save(newFornecedor);
    }

    public List<Fornecedor> listarFornecedor() {
        List<Fornecedor> fornecedores = fornecedorRepository.findAll();
        return fornecedores;
    }


    public Fornecedor findById(String id) {
        return fornecedorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid provider Id:" + id));
    }

    public void apagarFornecedorPorId(String id) {
        Fornecedor fornecedor = buscarFornecedorPorId(id);
        fornecedorRepository.delete(fornecedor);
    }

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


