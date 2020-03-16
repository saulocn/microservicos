package br.com.saulocn.microservicos.loja.client;


import java.util.List;

import br.com.saulocn.microservicos.loja.controller.vo.ItemPedidoVO;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient("fornecedor")
public interface FornecedorClient {

    @GetMapping("/produtos/hasInStock/ids")
    @Headers(value = "Content-Type: application/json")
    boolean hasInStock(@RequestBody List<ItemPedidoVO> itens);
}
