package br.com.saulocn.microservicos.loja.controller;

import java.util.List;

import br.com.saulocn.microservicos.loja.controller.vo.PedidoVO;
import br.com.saulocn.microservicos.loja.service.PedidoService;
import br.com.saulocn.microservicos.loja.service.exceptions.NoStockAvaibleException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public PedidoVO novoPedido(@RequestBody PedidoVO pedidoVO) throws NoStockAvaibleException {
        return pedidoService.criaPedido(pedidoVO);
    }

    @GetMapping("/{id}")
    public PedidoVO getPedido(@PathVariable Long id) {
        return pedidoService.obterPedido(id);
    }

    @GetMapping()
    public List<PedidoVO> listPedidos() {
        return pedidoService.listaPedidos();
    }

}
