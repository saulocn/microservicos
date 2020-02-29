package br.com.saulocn.microservicos.fornecedor.service;

import static br.com.saulocn.microservicos.fornecedor.controller.vo.ProdutoVO.asProdutoVOList;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.saulocn.microservicos.fornecedor.controller.vo.ProdutoVO;
import br.com.saulocn.microservicos.fornecedor.dao.ProdutoDAO;
import br.com.saulocn.microservicos.fornecedor.model.Produto;

@ApplicationScoped
public class ProdutoService {

    @Inject
    ProdutoDAO produtoDAO;

    public void save(ProdutoVO produtoVO) {
        produtoDAO.saveOrUpdate(new Produto(produtoVO));
    }

    public ProdutoVO get(Long id) {
        return new ProdutoVO(produtoDAO.getById(id));
    }

    public List<ProdutoVO> list() {
        return asProdutoVOList(produtoDAO.list());
    }

    public void update(ProdutoVO produtoVO) {
        produtoDAO.saveOrUpdate(new Produto(produtoVO));
    }

    public void delete(Long id) {
        produtoDAO.delete(id);
    }

    public boolean hasInStock(List<Long> ids) {
        final List<Produto> produtos = produtoDAO.getByIds(ids);
        boolean hasInStock = true;
        for (Produto produto : produtos) {
            if (produto.getQuantidade() == 0) hasInStock = false;
        }
        return hasInStock;
    }

    public List<ProdutoVO> getByIds(List<Long> ids) {
        return asProdutoVOList(produtoDAO.getByIds(ids));
    }
}
