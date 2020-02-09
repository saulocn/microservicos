package br.com.saulocn.microservicos.fornecedor.service;

import br.com.saulocn.microservicos.fornecedor.dao.FornecedorDAO;
import br.com.saulocn.microservicos.fornecedor.model.Fornecedor;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class FornecedorService {

    @Inject
    FornecedorDAO fornecedorDAO;

    public void salvarFornecedor(Fornecedor fornecedor) {
        fornecedorDAO.save(fornecedor);
    }

    public Fornecedor getFornecedor(Long id) {
        return fornecedorDAO.getById(id);
    }
}
