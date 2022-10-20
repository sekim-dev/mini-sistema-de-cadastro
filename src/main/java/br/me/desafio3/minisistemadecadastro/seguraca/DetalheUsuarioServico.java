package br.me.desafio3.minisistemadecadastro.seguraca;

import br.me.desafio3.minisistemadecadastro.models.Usuario;
import br.me.desafio3.minisistemadecadastro.repository.UsuarioRepository;
import org.apache.catalina.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.userdetails.UserDetails;

@Service
@Transactional
public class DetalheUsuarioServico implements UserDetailsService {

    private UsuarioRepository usuarioRepository;

    public DetalheUsuarioServico(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usuario usuario = usuarioRepository.findByEmailUsuario(username);

        if(usuario != null) {

//            User user = new User(usuario.getEmailUsuario(), usuario.getSenha());
//            return user;
            DetalheUsuario detalheUsuario = new DetalheUsuario(usuario);
            return detalheUsuario;
        } else {
            throw new UsernameNotFoundException("Usuário não encontrado");
        }
    }

}
