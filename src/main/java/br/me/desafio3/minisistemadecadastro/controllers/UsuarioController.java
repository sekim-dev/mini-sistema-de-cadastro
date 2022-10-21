package br.me.desafio3.minisistemadecadastro.controllers;

import br.me.desafio3.minisistemadecadastro.models.Usuario;
import br.me.desafio3.minisistemadecadastro.repository.UsuarioRepository;
import br.me.desafio3.minisistemadecadastro.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private BCryptPasswordEncoder criptografia;


    @GetMapping("/index")
    public String index(@CurrentSecurityContext(expression = "authentication.emailUsuario")
                        String login) {
        Usuario usuario = usuarioRepository.findByEmailUsuario(login);

        String redirectURL = "/cadastro-usuario";
        return redirectURL;
    }

    @GetMapping("/novo")
    public String adicionarUsuario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "/cadastro-usuario";
    }

    @PostMapping("/salvar")
    public String salvarUsuario(Usuario usuario, Model model, RedirectAttributes attributes) {

        Usuario usr = usuarioRepository.findByEmailUsuario(usuario.getEmailUsuario());
        if (usr != null) {
            model.addAttribute("emailExiste", "Email já existe cadastrado");
            return "/cadastro-usuario";
        }
        String senhaCriptografia = criptografia.encode(usuario.getSenha());
        usuario.setSenha(senhaCriptografia);

        usuarioRepository.insert(usuario);
        attributes.addFlashAttribute("mensagem", "Usuário salvo com sucesso!");
        return "redirect:/usuario/novo";

    }


//    @PostMapping("/salvar")
//    public ResponseEntity<String> addUsuario(Usuario usuario) {
//        return ResponseEntity.ok().body("cadastro realizado com sucesso");
//    }
//
//    @GetMapping("/novo")
//    public String addUsuario(Model model) {
//        model.addAttribute("usuario", new Usuario());
//        return "/cadastro-usuario";
//    }
//    //        @Autowired
////        private UsuarioRepository usuarioRepository;
////

//

//
//

/*


////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<UsuarioDTO>> findAll() {
        List<Usuario> list = usuarioService.findAll();
        List<UsuarioDTO> listDto = list.stream().map(x -> new UsuarioDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<UsuarioDTO> findById(@PathVariable String id) {
        Usuario obj = usuarioService.findById(id);
        return ResponseEntity.ok().body(new UsuarioDTO(obj));
    }

    @RequestMapping(value = "/new") //(method=RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody UsuarioDTO objDto) {
        Usuario obj = usuarioService.fromDTO(objDto);
        obj = usuarioService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable String id) {
        usuarioService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody UsuarioDTO objDto, @PathVariable String id) {
        Usuario obj = usuarioService.fromDTO(objDto);
        obj.setId(id);
        obj = usuarioService.update(obj);
        return ResponseEntity.noContent().build();
    }*/

}

