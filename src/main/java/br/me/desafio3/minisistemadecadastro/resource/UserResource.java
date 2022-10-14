package br.me.desafio3.minisistemadecadastro.resource;

import br.me.desafio3.minisistemadecadastro.models.User;
import br.me.desafio3.minisistemadecadastro.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)  // @GetMapping
    public ResponseEntity<List<User>> findAll() {
//        User salo = new User("1", "salo@salo.com", "0000", "0000");
//        User amanda = new User("2", "amanda@amanda.com", "9999", "9999");
        List<User> list = userService.findAll();
//        list.addAll(Arrays.asList(salo, amanda));
        return ResponseEntity.ok().body(list);
    }
}

