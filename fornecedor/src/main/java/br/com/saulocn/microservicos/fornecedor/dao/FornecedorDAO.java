package br.com.saulocn.microservicos.fornecedor.dao;

import br.com.saulocn.microservicos.fornecedor.model.Fornecedor;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@ApplicationScoped
public class FornecedorDAO {

    @Inject
    EntityManager em;

    @Transactional
    public void save(Fornecedor fornecedor) {
        em.merge(fornecedor);
    }

    public Fornecedor getById(Long id) {
        return em.find(Fornecedor.class, id);
    }
}
