package br.me.desafio3.minisistemadecadastro.models;

public class Fornecedor {

    private String id;
    private String nomeFornecedor;
    private String nomeContato;
    private String emailContato;
    private boolean cnpjCpf;
    private String numeroDocumento;
    private String telefone;
    private Endereco endereco;

    public Fornecedor() {
    }

    public Fornecedor(String id, String nomeFornecedor, String nomeContato, String emailContato, boolean cnpjCpf, String numeroDocumento, String telefone, Endereco endereco) {
        this.id = id;
        this.nomeFornecedor = nomeFornecedor;
        this.nomeContato = nomeContato;
        this.emailContato =emailContato;
        this.cnpjCpf = cnpjCpf;
        this.numeroDocumento = numeroDocumento;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public String getId(){
        return id;
    }
    public void setId(){
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
