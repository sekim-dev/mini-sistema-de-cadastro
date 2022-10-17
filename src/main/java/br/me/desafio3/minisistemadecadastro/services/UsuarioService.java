package br.me.desafio3.minisistemadecadastro.services;

import br.me.desafio3.minisistemadecadastro.dto.UsuarioDTO;
import br.me.desafio3.minisistemadecadastro.models.Usuario;
import br.me.desafio3.minisistemadecadastro.repository.UsuarioRepository;
import br.me.desafio3.minisistemadecadastro.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {


    @Autowired
    private UsuarioRepository usuarioRepo;
    public void save(Usuario usuario) {
        this.usuarioRepo.save(usuario);
    }

    public List<Usuario> findAll() {
        return usuarioRepo.findAll();
    }

    public Usuario findById(String id) {
        Optional<Usuario> obj = usuarioRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }
public String addUser(Model model){
        model.addAttribute("usuario", new Usuario());
        return "/cadastro-usuario";
}
    public Usuario insert(Usuario obj) {
        return usuarioRepo.insert(obj);
    }

    public void delete(String id) {
        findById(id);
        usuarioRepo.deleteById(id);
    }

    public Usuario update(Usuario obj) {
        Usuario newObj = findById(obj.getId());
        updateData(newObj, obj);
        return usuarioRepo.save(newObj);
    }

    private void updateData(Usuario newObj, Usuario obj) {
        newObj.setEmailUsuario(obj.getEmailUsuario());
        newObj.setSenha(obj.getSenha());

    }

    public Usuario fromDTO(UsuarioDTO objDto) {
        return new Usuario();
    }


}
