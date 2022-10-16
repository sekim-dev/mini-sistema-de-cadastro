package br.me.desafio3.minisistemadecadastro.models;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection="fornecedor")
public class Fornecedor {
@Id
    private String id;
    private String nomeFornecedor;
    private String nomeContato;
    private String emailContato;
    private boolean cnpjCpf;
    private String numeroDocumento;
    private List<String> telefoneList;
    private List<Endereco> endereco;

    public Fornecedor() {
    }

    public Fornecedor(String id, String nomeFornecedor, String nomeContato, String emailContato, boolean cnpjCpf, String numeroDocumento, List<String> telefoneList){ //}, Endereco endereco) {
        this.id = id;
        this.nomeFornecedor = nomeFornecedor;
        this.nomeContato = nomeContato;
        this.emailContato =emailContato;
        this.cnpjCpf = cnpjCpf;
        this.numeroDocumento = numeroDocumento;
        this.telefoneList = telefoneList;
        this.endereco = endereco;
    }

    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = this.id;
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

    public boolean isCnpjCpf() {
        return cnpjCpf;
    }
    public void setCnpjCpf(boolean cnpjCpf) {
        this.cnpjCpf = cnpjCpf;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public List<String> getTelefoneList() {
        return telefoneList;
    }

    public void setTelefoneList(List<String> telefoneList) {
        this.telefoneList = telefoneList;
    }

//    public Endereco getEndereco() {
//        return endereco;
//    }

//    public void setEndereco(Endereco endereco) {
//        this.endereco = endereco;
//    }


}
