package br.me.desafio3.minisistemadecadastro.services;


import br.me.desafio3.minisistemadecadastro.models.Usuario;
import br.me.desafio3.minisistemadecadastro.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder criptografia;

    @Override
    public void apagarUsuarioPorId(String id) {
        Usuario usuario = buscarUsuarioPorId(id);
        usuarioRepository.delete(usuario);
    }

    @Override
    public Usuario buscarUsuarioPorId(String id) {
        Optional<Usuario> opt = usuarioRepository.findById(String.valueOf(id));
        if (opt.isPresent()) {
            return opt.get();
        } else {
            throw new IllegalArgumentException("Usuário com id : " + id + " não existe");
        }
    }

    @Override
    public Usuario buscarUsuarioPorEmail(String email) {
        Usuario usuario = usuarioRepository.findByEmail(email);
        return usuario;
    }

    @Override
    public Usuario gravarUsuario(Usuario usuario) {

        String senhaCriptografia = criptografia.encode(usuario.getPassword());
        usuario.setPassword(senhaCriptografia);

        return usuarioRepository.save(usuario);
    }

    @Override
    public void alterarUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public List<Usuario> listarUsuario() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios;
    }


}
//    @Autowired
//    private UsuarioRepository usuarioRepo;
////
//    @Autowired
//    private BCryptPasswordEncoder criptografia;
//
////    public void save(Usuario usuario) {
////        this.usuarioRepo.save(usuario);
////    }
//
//    public List<Usuario> findAll() {
//        return usuarioRepo.findAll();
//    }
//
//    public Usuario findById(String id) {
//        Optional<Usuario> obj = usuarioRepo.findById(id);
//        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
//    }
////public String addUser(Model model){
////        model.addAttribute("usuario", new Usuario());
////        return "/cadastro-usuario";
////}
//    public Usuario insert(Usuario obj) {
//        return usuarioRepo.insert(obj);
//    }
//
//    public void delete(String id) {
//        findById(id);
//        usuarioRepo.deleteById(id);
//    }
//
//    public Usuario update(Usuario obj) {
//        Usuario newObj = findById(obj.getId());
//        updateData(newObj, obj);
//        return usuarioRepo.save(newObj);
//    }
//
//    private void updateData(Usuario newObj, Usuario obj) {
//        newObj.setEmail(obj.getEmail());
////        newObj.setPassword(obj.getPassword());
//
//    }
//
////    public Usuario fromDTO(UsuarioDTO objDto) {
////        return new Usuario();
////    }
//
//
//}
