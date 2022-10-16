package br.me.desafio3.minisistemadecadastro.controllers;

import br.me.desafio3.minisistemadecadastro.models.User;
import br.me.desafio3.minisistemadecadastro.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/usuario")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/novo")
    public String adicionarUsuario(Model model) {
        model.addAttribute("usuario", new User());
        return "/cadastro-usuario";
    }

        @PostMapping("/salvar")
    public String salvarUsuario(User user, BindingResult result,
                                 RedirectAttributes attributes) {
//        if (result.hasErrors()) {
//            return "/cadastro-usuario";
//        }
        userService.insert(user);
        attributes.addFlashAttribute("mensagem", "Usuário salvo com sucesso!" + user);
        return "redirect:/usuario/novo";

    }

//    @PostMapping("/salvar")
//    public ResponseEntity<String> addUser(User user) {
//        return ResponseEntity.ok().body("cadastro realizado com sucesso");
//    }
//
//    @GetMapping("/novo")
//    public String addUser(Model model) {
//        model.addAttribute("usuario", new User());
//        return "/cadastro-usuario";
//    }
//    //        @Autowired
////        private UserRepository usuarioRepository;
////

//

//
//

/*


////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> list = userService.findAll();
        List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {
        User obj = userService.findById(id);
        return ResponseEntity.ok().body(new UserDTO(obj));
    }

    @RequestMapping(value = "/new") //(method=RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody UserDTO objDto) {
        User obj = userService.fromDTO(objDto);
        obj = userService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable String id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody UserDTO objDto, @PathVariable String id) {
        User obj = userService.fromDTO(objDto);
        obj.setId(id);
        obj = userService.update(obj);
        return ResponseEntity.noContent().build();
    }*/

}

