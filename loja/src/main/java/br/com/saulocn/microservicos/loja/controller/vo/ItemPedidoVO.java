package br.com.saulocn.microservicos.loja.controller.vo;


import br.com.saulocn.microservicos.loja.model.ItemPedido;

public class ItemPedidoVO {
    private Long id;
    private String nome;
    private Long produtoId;
    private Integer quantidade;

    public ItemPedidoVO() {
    }

    public ItemPedidoVO(ItemPedido item) {
        this.id = item.getId();
        this.nome = item.getNome();
        this.produtoId = item.getProdutoId();
        this.quantidade = item.getQuantidade();
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
