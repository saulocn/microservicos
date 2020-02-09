package br.com.saulocn.microservicos.loja.service;

import br.com.saulocn.microservicos.loja.controller.vo.PedidoVO;
import br.com.saulocn.microservicos.loja.model.Pedido;
import br.com.saulocn.microservicos.loja.repository.PedidoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    private static final Logger LOG = LoggerFactory.getLogger(PedidoService.class);

    @Autowired
    PedidoRepository pedidoRepository;

    public PedidoVO criaPedido(PedidoVO pedidoVO) {
        LOG.info("Criando novo pedidoVO {}", pedidoVO);
        final Pedido pedido = new Pedido(pedidoVO);
        pedidoRepository.save(pedido);
        pedidoVO = new PedidoVO(pedido);
        pedidoVO.setId(pedido.getId());
        return pedidoVO;
    }

    public PedidoVO obterPedido(Long id) {
        LOG.info("Obtendo pedido {}", id);
        final Pedido pedido = pedidoRepository.findById(id).orElse(new Pedido());
        LOG.info("Pedido obtido {}", pedido);
        return new PedidoVO(pedido);
    }
}
