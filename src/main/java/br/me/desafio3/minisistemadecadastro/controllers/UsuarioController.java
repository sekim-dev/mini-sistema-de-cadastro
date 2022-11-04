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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

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
    public String index(@CurrentSecurityContext(expression = "authentication.email")
                        String login) {
        Usuario usuario = usuarioRepository.findByEmail(login);

        String redirectURL = "/cadastro-usuario";
        return redirectURL;
    }

    @GetMapping("/novo")
    public String adicionarUsuario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "cadastro-usuario";
    }


    @PostMapping("/salvar")
    public String salvarUsuario(Usuario usuario, Model model, RedirectAttributes attributes) {

        Usuario usr = usuarioService.buscarUsuarioPorEmail(usuario.getEmail());
        if (usr != null) {
            model.addAttribute("emailExiste", "Email já existe cadastrado");
            return "cadastro-usuario";
        }

        usuarioService.gravarUsuario(usuario);
        attributes.addFlashAttribute("mensagem", "Usuário salvo com sucesso!");
        return "redirect:/login";

    }

    @RequestMapping("/admin/listar")
    public String listarUsuario(Model model) {
        List<Usuario> lista = usuarioService.listarUsuario();
        model.addAttribute("usuarios", lista);
        return "admin/admin-listar-usuario";
    }

    @GetMapping("/admin/apagar/{id}")
    public String deleteUser(@PathVariable("id") String id, Model model) {
        usuarioService.apagarUsuarioPorId(id);
        return "redirect:/usuario/admin/listar";
    }

    @GetMapping("/editar/{id}")
    public String editarUsuario(@PathVariable("id") String id, Model model, Usuario usuario) {
        usuarioService.alterarUsuario(usuario);
        return "redirect:/usuario/admin/listar";

    }
}
