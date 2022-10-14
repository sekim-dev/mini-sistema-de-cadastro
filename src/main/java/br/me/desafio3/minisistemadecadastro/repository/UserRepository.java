package br.me.desafio3.minisistemadecadastro.repository;

import br.me.desafio3.minisistemadecadastro.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User,String> {
}
