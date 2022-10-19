package br.me.desafio3.minisistemadecadastro.services;

import br.me.desafio3.minisistemadecadastro.models.Endereco;
import br.me.desafio3.minisistemadecadastro.models.Fornecedor;
import br.me.desafio3.minisistemadecadastro.repository.FornecedorRepository;
import br.me.desafio3.minisistemadecadastro.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {
    @Autowired
    private FornecedorRepository fornecedorRepo;

    public List<Fornecedor> findAll() {
        return fornecedorRepo.findAll();
    }

    public Fornecedor findById(String id) {
        Optional<Fornecedor> obj = fornecedorRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public Fornecedor insert(Fornecedor obj) {
              return fornecedorRepo.insert(obj);
    }

//    public listaTabela(){
//        var tbody =
//    }

    public void delete(String id) {
        findById(id);
        fornecedorRepo.deleteById(id);
    }

    public Fornecedor update(Fornecedor obj) {
        Fornecedor newObj = findById(obj.getId());
        updateData(newObj, obj);
        return fornecedorRepo.save(newObj);
    }

    private void updateData(Fornecedor newObj, Fornecedor obj) {
        newObj.setEmailContato(obj.getEmailContato());
    }




}


