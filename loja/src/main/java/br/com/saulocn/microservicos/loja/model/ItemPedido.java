package br.com.saulocn.microservicos.loja.model;

import br.com.saulocn.microservicos.loja.controller.vo.ItemPedidoVO;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nome;
    private Long produtoId;
    private Integer quantidade;

    public ItemPedido() {
    }

    public ItemPedido(ItemPedidoVO item) {
        this.id = item.getId();
        this.nome = item.getNome();
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
        return "ItemPedido{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
