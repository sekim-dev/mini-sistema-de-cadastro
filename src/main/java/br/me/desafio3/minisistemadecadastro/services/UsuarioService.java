package br.me.desafio3.minisistemadecadastro.services;

import br.me.desafio3.minisistemadecadastro.models.Usuario;

import java.util.List;

public interface UsuarioService {
    public void apagarUsuarioPorId(String id);
    public Usuario buscarUsuarioPorId(String id);
    public Usuario buscarUsuarioPorEmail(String email);
    public Usuario gravarUsuario(Usuario usuario);
    public void alterarUsuario(Usuario usuario);
    public List<Usuario> listarUsuario();
}


