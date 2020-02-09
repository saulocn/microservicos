package br.com.saulocn.microservicos.fornecedor;

import br.com.saulocn.microservicos.fornecedor.model.Fornecedor;
import br.com.saulocn.microservicos.fornecedor.service.FornecedorService;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

@Path("/fornecedor")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FornecedorResource {

    @Inject
    FornecedorService fornecedorService;

    @GET
    @Path("/{id}")
    public Fornecedor getFornecedor(@PathParam Long id) {
        return fornecedorService.getFornecedor(id);
    }


    @POST
    public void criaFornecedor(Fornecedor fornecedor) {
        fornecedorService.salvarFornecedor(fornecedor);
    }
}