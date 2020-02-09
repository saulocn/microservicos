package br.com.saulocn.microservicos.loja.repository;

import br.com.saulocn.microservicos.loja.model.Pedido;
import org.springframework.data.repository.CrudRepository;

public interface PedidoRepository extends CrudRepository<Pedido, Long> {
}
