package br.com.saulocn.microservicos.fornecedor.model;

import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.saulocn.microservicos.fornecedor.controller.vo.ProdutoVO;

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nome;
    private String codigo;
    private Integer quantidade;
    private String ufFornecedor;

    public Produto() {
    }

    public Produto(Long id, String nome, String codigo, Integer quantidade) {
        this.id = id;
        this.nome = nome;
        this.codigo = codigo;
        this.quantidade = quantidade;
    }

    public Produto(Long id, String nome, String codigo, Integer quantidade, String ufFornecedor) {
        this.id = id;
        this.nome = nome;
        this.codigo = codigo;
        this.quantidade = quantidade;
        this.ufFornecedor = ufFornecedor;
    }

    public Produto(ProdutoVO produto) {
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.quantidade = produto.getQuantidade();
        this.ufFornecedor = produto.getUfFornecedor();
    }

    public Produto(Long id, String nome, String codigo) {
        this.id = id;
        this.nome = nome;
        this.codigo = codigo;
    }

    public String getUfFornecedor() {
        return ufFornecedor;
    }

    public void setUfFornecedor(String ufFornecedor) {
        this.ufFornecedor = ufFornecedor;
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public static List<Produto> asProdutoList(List<ProdutoVO> produtosVO) {
        return produtosVO.stream().map(produtoVO -> new Produto(produtoVO)).collect(Collectors.toList());
    }
}
