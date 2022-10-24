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

