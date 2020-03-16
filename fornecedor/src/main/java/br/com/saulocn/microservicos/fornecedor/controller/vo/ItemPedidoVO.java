package br.com.saulocn.microservicos.fornecedor.controller.vo;


import com.fasterxml.jackson.annotation.JsonIgnore;

public class ItemPedidoVO {
    @JsonIgnore
    private Long id;
    @JsonIgnore
    private String nome;
    private Long produtoId;
    private Integer quantidade;

    public ItemPedidoVO() {
    }


    public Long getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Long produtoId) {
        this.produtoId = produtoId;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "ItemPedidoVO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}

