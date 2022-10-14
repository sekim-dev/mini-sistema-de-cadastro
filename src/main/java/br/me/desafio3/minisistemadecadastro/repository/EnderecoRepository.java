package br.me.desafio3.minisistemadecadastro.repository;

import br.me.desafio3.minisistemadecadastro.models.Endereco;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EnderecoRepository extends MongoRepository<Endereco,Long> {
}
