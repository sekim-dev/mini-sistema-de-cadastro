package br.me.desafio3.minisistemadecadastro.dto;

import br.me.desafio3.minisistemadecadastro.models.Usuario;

import java.io.Serializable;

public class UsuarioDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;

	private String emailUsuario;
	
	public UsuarioDTO() {
	}
	
	public UsuarioDTO(Usuario obj) {
		id = obj.getId();
		emailUsuario = obj.getEmailUsuario();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}
}
