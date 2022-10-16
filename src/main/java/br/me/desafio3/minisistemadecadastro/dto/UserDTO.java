package br.me.desafio3.minisistemadecadastro.dto;

import br.me.desafio3.minisistemadecadastro.models.User;

import java.io.Serializable;

public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;

	private String email;
	
	public UserDTO() {
	}
	
	public UserDTO(User obj) {
		id = obj.getId();
		email = obj.getEmail();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
