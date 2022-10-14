package br.me.desafio3.minisistemadecadastro.models;



public class Endereco {

    private String id;
    private String cep;
    private String lograedouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;

    public Endereco() {
    }

    public Endereco(String id, String cep, String lograedouro, String numero, String complemento, String bairro, String cidade, String estado) {
        this.id = id;
        this.cep = cep;
        this.lograedouro = lograedouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    public String getId() {
        return id;
    }

    public void setId() {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep() {
        this.cep = cep;
    }

    public String getLograedouro() {
        return lograedouro;
    }

    public void setLograedouro() {
        this.lograedouro = lograedouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero() {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento() {
        this.complemento = complemento;
    }
public String getBairro(){
        return complemento;
}
public void setBairro(){
        this.bairro = bairro;
}
public String getEstado(){
        return estado;
}
public void setEstado(){
        this.estado = estado;
}
public String getCidade(){
        return cidade;
}
public void setCidade(){
        this.cidade = cidade;
}
}
