package br.com.saulocn.microservicos.loja.controller.vo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import br.com.saulocn.microservicos.loja.model.ItemPedido;
import br.com.saulocn.microservicos.loja.model.Pedido;

public class PedidoVO {

    private UUID id;

    private LocalDateTime data;

    private LocalDateTime dataEntrega;

    private EnderecoVO endereco;

    private List<ItemPedidoVO> itensPedido;

    private String observacao;

    private StatusPedido status;

    public PedidoVO() {
    }

    public PedidoVO(Pedido pedido) {
        this.id = pedido.getId();
        this.data = pedido.getData();
        this.dataEntrega = pedido.getData();
        this.endereco = new EnderecoVO(pedido.getEndereco());
        this.itensPedido = toItensPedidoVO(pedido.getItensPedido());
        this.observacao = pedido.getObservacao();
        this.status = pedido.getStatus();
    }

    private List<ItemPedidoVO> toItensPedidoVO(List<ItemPedido> itensPedido) {
        List<ItemPedidoVO> itensPedidoVO = new ArrayList<>();
        itensPedido.forEach(item -> itensPedidoVO.add(new ItemPedidoVO(item)));
        return itensPedidoVO;
    }

    public static List<PedidoVO> toPedidosVO(List<Pedido> pedidos) {
        return pedidos.stream().map(pedido -> new PedidoVO(pedido)).collect(Collectors.toList());
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public LocalDateTime getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(LocalDateTime dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public EnderecoVO getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoVO endereco) {
        this.endereco = endereco;
    }

    public List<ItemPedidoVO> getItensPedido() {
        return itensPedido;
    }

    public void setItensPedido(List<ItemPedidoVO> itensPedido) {
        this.itensPedido = itensPedido;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "PedidoVO{" +
                "id=" + id +
                ", data=" + data +
                ", dataEntrega=" + dataEntrega +
                ", endereco=" + endereco +
                ", itensPedido=" + itensPedido +
                ", observacao='" + observacao + '\'' +
                ", status=" + status +
                '}';
    }
}
