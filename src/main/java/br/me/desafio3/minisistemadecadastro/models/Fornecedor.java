package br.me.desafio3.minisistemadecadastro.models;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Document(collection="fornecedor")
public class Fornecedor {
@Id
    private String id;
    private String nomeFornecedor;
    private String nomeContato;
    private String emailContato;
    private String cnpjCpf;
    private String numeroDocumento;
    private List<String> telefoneLista = new ArrayList<>();
    private Endereco endereco;
private String descricao;
    public Fornecedor() {
    }

    public Fornecedor(String nomeFornecedor, String nomeContato, String emailContato, String cnpjCpf, String numeroDocumento, List<String> telefoneLista, Endereco endereco, String descricao) {

        this.nomeFornecedor = nomeFornecedor;
        this.nomeContato = nomeContato;
        this.emailContato =emailContato;
        this.cnpjCpf = cnpjCpf;
        this.numeroDocumento = numeroDocumento;
        this.telefoneLista = telefoneLista;
        this.endereco = endereco;
        this.descricao = descricao;
    }

    public Fornecedor(String id, String nomeFornecedor, String nomeContato, String emailContato, String cnpjCpf, String numeroDocumento, List<String> telefoneLista, Endereco endereco, String descricao) {
        this.id = id;
        this.nomeFornecedor = nomeFornecedor;
        this.nomeContato = nomeContato;
        this.emailContato =emailContato;
        this.cnpjCpf = cnpjCpf;
        this.numeroDocumento = numeroDocumento;
        this.telefoneLista = telefoneLista;
        this.endereco = endereco;
        this.descricao = descricao;
    }

    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getNomeFornecedor() {
        return nomeFornecedor;
    }
    public void setNomeFornecedor(String nomeFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
    }
    public String getNomeContato() {
        return nomeContato;
    }
    public void setNomeContato(String nomeContato) {
        this.nomeContato = nomeContato;
    }

    public String getEmailContato() {
        return emailContato;
    }
    public void setEmailContato(String emailContato) {
        this.emailContato = emailContato;
    }

    public String getCnpjCpf() {
        return cnpjCpf;
    }
    public void setCnpjCpf(String cnpjCpf) {
        this.cnpjCpf = cnpjCpf;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public List<String> getTelefoneLista() {
        return telefoneLista;
    }
    public void setTelefoneLista(List<String> telefoneLista) {
        this.telefoneLista = telefoneLista;
    }

    public Endereco getEndereco() {
        return endereco;
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fornecedor)) return false;
        Fornecedor that = (Fornecedor) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }



    @Override
    public String toString() {
        String test = new String();

        for (String i : telefoneLista) {
            test += getTelefoneLista() + " ; ";
        }
        return test;
    }
}
