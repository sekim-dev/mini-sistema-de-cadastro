package br.me.desafio3.minisistemadecadastro.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Objects;

@Document(collection="user")
public class User implements Serializable {
@Id
    private String id;
    private String email;
    private String senha;
    private String confirmacaoSenha;

    public User() {
    }
    public User (String id, String email, String senha, String confirmacaoSenha) {
        super();
        this.id = id;
        this.email = email;
        this.senha = senha;
        this.confirmacaoSenha = confirmacaoSenha;
    }

    public String getId(){
        return id;
    }
    public void setId(){
        this.id = id;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(){
        this.email = email;
    }
    public String getSenha(){
        return senha;
    }
    public void setsenha(){
        this.senha = senha;
    }
public String getconfirmacaoSenha (){
        return confirmacaoSenha;
}
public void setConfirmacaoSenha (){
        this.confirmacaoSenha = confirmacaoSenha;
}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(getId(), user.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString(){
        return "User [id=" + id + ",email=" + email + ", senha=" + senha + ", confirmacaoSenha=" + confirmacaoSenha + "]";
}
}