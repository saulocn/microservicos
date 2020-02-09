package br.com.saulocn.microservicos.loja.controller;

import br.com.saulocn.microservicos.loja.controller.vo.PedidoVO;
import br.com.saulocn.microservicos.loja.service.PedidoService;
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
    PedidoService pedidoService;

    @PostMapping
    public PedidoVO novoPedido(@RequestBody PedidoVO pedidoVO) {
        pedidoService.criaPedido(pedidoVO);
        return pedidoVO;
    }

    @GetMapping("/{id}")
    public PedidoVO getPedido(@PathVariable Long id) {
        final PedidoVO pedidoVO = pedidoService.obterPedido(id);
        return pedidoVO;
    }

}
