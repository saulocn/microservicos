package br.com.saulocn.microservicos.loja.controller.vo;

import br.com.saulocn.microservicos.loja.model.Endereco;

public class EnderecoVO {
    private Long id;
    private String uf;
    private String logradouro;
    private String numero;

    public EnderecoVO() {
    }

    public EnderecoVO(Endereco endereco) {
        this.id = endereco.getId();
        this.uf = endereco.getUf();
        this.logradouro = endereco.getLogradouro();
        this.numero = endereco.getNumero();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "EnderecoVO{" +
                "id=" + id +
                ", uf='" + uf + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", numero='" + numero + '\'' +
                '}';
    }
}

