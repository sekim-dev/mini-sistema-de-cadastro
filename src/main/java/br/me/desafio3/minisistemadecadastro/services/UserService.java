package br.me.desafio3.minisistemadecadastro.services;

import br.me.desafio3.minisistemadecadastro.dto.UserDTO;
import br.me.desafio3.minisistemadecadastro.models.User;
import br.me.desafio3.minisistemadecadastro.repository.UserRepository;
import br.me.desafio3.minisistemadecadastro.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    public List<User> findAll() {
        return userRepo.findAll();
    }

    public User findById(String id) {
        Optional<User> obj = userRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }
public String addUser(Model model){
        model.addAttribute("usuario", new User());
        return "/cadastro-usuario";
}
    public User insert(User obj) {
        return userRepo.insert(obj);
    }

    public void delete(String id) {
        findById(id);
        userRepo.deleteById(id);
    }

    public User update(User obj) {
        User newObj = findById(obj.getId());
        updateData(newObj, obj);
        return userRepo.save(newObj);
    }

    private void updateData(User newObj, User obj) {
        newObj.setEmail(obj.getEmail());
    }

    public User fromDTO(UserDTO objDto) {
        return new User();
    }
}
