package br.me.desafio3.minisistemadecadastro.repository;

import br.me.desafio3.minisistemadecadastro.models.Endereco;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends MongoRepository<Endereco,String> {
}
