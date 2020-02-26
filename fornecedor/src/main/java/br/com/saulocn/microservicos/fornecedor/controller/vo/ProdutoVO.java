package br.com.saulocn.microservicos.fornecedor.controller.vo;

import java.util.List;
import java.util.stream.Collectors;

import br.com.saulocn.microservicos.fornecedor.model.Produto;

public class ProdutoVO {

    private long id;
    private String nome;
    private int quantidade;

    public ProdutoVO(long id, String nome, int quantidade) {
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public ProdutoVO(Produto produto) {
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.quantidade = produto.getQuantidade();
    }

    public ProdutoVO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }


    public static List<ProdutoVO> asProdutoVOList(List<Produto> produtos) {
        return produtos.stream().map(produto -> new ProdutoVO(produto)).collect(Collectors.toList());
    }
}
