package br.com.saulocn.microservicos.fornecedor.dao;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import br.com.saulocn.microservicos.fornecedor.model.Produto;

@ApplicationScoped
public class ProdutoDAO {

    @Inject
    EntityManager em;

    @Transactional
    public void saveOrUpdate(final Produto produto) {
        em.merge(produto);
    }

    public Produto getById(Long id) {
        return em.find(Produto.class, id);
    }

    public List<Produto> list() {
        return em.createQuery("select p from Produto p", Produto.class).getResultList();
    }

    @Transactional
    public void delete(Long id) {
        final Produto produto = em.find(Produto.class, id);
        em.remove(produto);
    }

    @Transactional
    public void updateAmount(Long id, int quantidade) {
        final Produto produto = em.find(Produto.class, id);
        produto.setQuantidade(quantidade);
        em.merge(produto);
    }

    public List<Produto> getByIds(List<Long> ids) {
        return em.createQuery("SELECT p FROM Produto p WHERE p.id IN :ids", Produto.class).setParameter("ids", ids).getResultList();
    }
}
