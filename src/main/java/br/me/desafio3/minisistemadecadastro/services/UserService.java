package br.me.desafio3.minisistemadecadastro.services;

import br.me.desafio3.minisistemadecadastro.models.User;
import br.me.desafio3.minisistemadecadastro.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    public List<User> findAll() {
        return userRepo.findAll();
    }
}
