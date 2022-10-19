package br.me.desafio3.minisistemadecadastro.seguraca;

import br.me.desafio3.minisistemadecadastro.models.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class DetalheUsuario implements UserDetails {

    private Usuario usuario;

    public DetalheUsuario(Usuario usuario) {
        super();
        this.usuario = usuario;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        return usuario.getSenha();
    }

    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return usuario.getEmailUsuario();
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    public String getEmailUsuario() {
        return usuario.getEmailUsuario();
    }

}

