package br.me.desafio3.minisistemadecadastro.repository;

import br.me.desafio3.minisistemadecadastro.models.Fornecedor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecedorRepository extends MongoRepository<Fornecedor,String> {
}