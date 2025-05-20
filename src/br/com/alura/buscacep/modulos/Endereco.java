package br.com.alura.buscacep.modulos;

public class Endereco {
    private String cep;
    private String rua;
    private String bairro;
    private String cidade;
    private String estado;
    private String regiao;

    public Endereco(String cep, String rua, String bairro, String cidade, String estado, String regiao) {
        this.cep = cep;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.regiao = regiao;
    }

    public Endereco(EnderecoViaCep enderecoViaCep){
        this.cep = enderecoViaCep.cep();
        /*this.rua = enderecoViaCep.logradouro();
        this.bairro = enderecoViaCep.bairro();
        this.cidade = enderecoViaCep.localidade();
        this.estado = enderecoViaCep.estado();
        this.regiao = enderecoViaCep.regiao();*/
    }

    public String getCep() {
        return cep;
    }

    public String getRua() {
        return rua;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getRegiao() {
        return regiao;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "cep='" + cep + '\'' +
                ", rua='" + rua + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", regiao='" + regiao + '\'' +
                '}';
    }
}
