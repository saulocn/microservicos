package br.com.saulocn.microservicos.loja.service;

import java.util.List;

import br.com.saulocn.microservicos.loja.client.FornecedorClient;
import br.com.saulocn.microservicos.loja.controller.vo.PedidoVO;
import br.com.saulocn.microservicos.loja.model.Pedido;
import br.com.saulocn.microservicos.loja.pulsar.PulsarDispatcher;
import br.com.saulocn.microservicos.loja.repository.PedidoRepository;
import br.com.saulocn.microservicos.loja.service.exceptions.NoStockAvaibleException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    private static final Logger LOG = LoggerFactory.getLogger(PedidoService.class);


    @Autowired
    private FornecedorClient fornecedorClient;

    @Autowired
    private PulsarDispatcher<PedidoVO> pulsarDispatcher;

    @Autowired
    private PedidoRepository pedidoRepository;

    public PedidoVO criaPedido(PedidoVO pedidoVO) throws NoStockAvaibleException {
        final boolean hasInStock = fornecedorClient.hasInStock(pedidoVO.getItensPedido());
        LOG.info("Criando novo pedidoVO {}", pedidoVO);
        if (hasInStock) {
            Pedido pedido = new Pedido(pedidoVO);
            pedido = pedidoRepository.saveAndFlush(pedido);
            pedidoVO = new PedidoVO(pedido);
            pulsarDispatcher.send("pedidos", PedidoVO.class, pedidoVO);
            return pedidoVO;
        } else {
            throw new NoStockAvaibleException("Não temos um ou mais produtos em estoque!");
        }
    }

    public PedidoVO obterPedido(Long id) {
        LOG.info("Obtendo pedido {}", id);
        final Pedido pedido = pedidoRepository.findById(id).orElse(new Pedido());
        LOG.info("Pedido obtido {}", pedido);
        return new PedidoVO(pedido);
    }

    public List<PedidoVO> listaPedidos() {
        return PedidoVO.toPedidosVO(pedidoRepository.findAll());
    }
}
