package br.me.desafio3.minisistemadecadastro.seguraca;

import br.me.desafio3.minisistemadecadastro.models.Usuario;
import br.me.desafio3.minisistemadecadastro.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.userdetails.UserDetails;

@Service
@Transactional
public class DetalheUsuarioServico implements UserDetailsService {


    @Autowired
    private UsuarioRepository usuarioRepository;


    @Override
    public DetalheUsuario loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByEmail(username);
        if(usuario != null) {

            DetalheUsuario detalheUsuario = new DetalheUsuario(usuario);
            return detalheUsuario;
        } else {
            throw new UsernameNotFoundException("Usuário não encontrado");
        }
    }



}
