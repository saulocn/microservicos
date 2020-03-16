package br.com.saulocn.microservicos.loja.repository;

import br.com.saulocn.microservicos.loja.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
