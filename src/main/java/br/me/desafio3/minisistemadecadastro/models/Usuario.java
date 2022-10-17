package br.me.desafio3.minisistemadecadastro.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Objects;

@Document(collection="usuario")
public class Usuario {
@Id
    private String id;
    private String emailUsuario;
    private String senha;


    public Usuario() {
    }
    public Usuario(String id, String emailUsuario, String senha) {
        super();
        this.id = id;
        this.emailUsuario = emailUsuario;
        this.senha = senha;
    }

    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }

    public String getEmailUsuario(){
        return emailUsuario;
    }
    public void setEmailUsuario(String emailUsuario){
        this.emailUsuario = this.emailUsuario;
    }

    public String getSenha(){
        return senha;
    }
    public void setSenha(String senha){
        this.senha = this.senha;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Usuario)) return false;
//        Usuario usuario = (Usuario) o;
//        return Objects.equals(getId(), usuario.getId());
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(getId());
//    }
//
//    @Override
//    public String toString(){
//        return "Usuario [id=" + id + ",emailUsuario=" + emailUsuario + ", senha=" + senha + "]";
//}
}