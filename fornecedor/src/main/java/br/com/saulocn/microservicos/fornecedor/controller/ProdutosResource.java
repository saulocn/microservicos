package br.com.saulocn.microservicos.fornecedor.controller;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.saulocn.microservicos.fornecedor.controller.vo.ProdutoVO;
import br.com.saulocn.microservicos.fornecedor.service.ProdutoService;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

@Path("/produtos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutosResource {

    @Inject
    ProdutoService produtoService;

    @GET
    @Path("/{id}")
    public ProdutoVO getProduto(@PathParam Long id) {
        return produtoService.get(id);
    }

    @GET
    public List<ProdutoVO> listProduto(@PathParam Long id) {
        return produtoService.list();
    }

    @POST
    public void saveProduto(ProdutoVO produto) {
        produtoService.save(produto);
    }


    @PUT
    public void updateProduto(ProdutoVO produto) {
        produtoService.update(produto);
    }

    @GET
    @Path("/hasInStock/ids")
    public boolean hasInStock(List<Long> ids) {
        return produtoService.hasInStock(ids);
    }

    @GET
    @Path("/ids")
    public List<ProdutoVO> getByIds(List<Long> ids) {
        return produtoService.getByIds(ids);
    }

    @DELETE
    @Path("/{id}")
    public void deleteProduto(@PathParam Long id) {
        produtoService.delete(id);
    }

}