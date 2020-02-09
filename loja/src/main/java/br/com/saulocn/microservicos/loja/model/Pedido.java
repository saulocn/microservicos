package br.com.saulocn.microservicos.loja.model;

import br.com.saulocn.microservicos.loja.controller.vo.ItemPedidoVO;
import br.com.saulocn.microservicos.loja.controller.vo.PedidoVO;
import br.com.saulocn.microservicos.loja.controller.vo.StatusPedido;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private LocalDateTime data;
    private LocalDateTime dataEntrega;

    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "pedido_id")
    private List<ItemPedido> itensPedido;

    private String observacao;

    @Enumerated(EnumType.STRING)
    private StatusPedido status;

    public Pedido(PedidoVO pedidoVO) {
        this.id = pedidoVO.getId();
        this.data = pedidoVO.getData();
        this.dataEntrega = pedidoVO.getDataEntrega();
        this.endereco = new Endereco(pedidoVO.getEndereco());
        this.itensPedido = toItensPedido(pedidoVO.getItensPedido());
        this.observacao = pedidoVO.getObservacao();
        this.status = pedidoVO.getStatus();
    }

    private List<ItemPedido> toItensPedido(List<ItemPedidoVO> itensPedidoVO) {
        List<ItemPedido> itensPedido = new ArrayList<>();
        itensPedidoVO.forEach(item -> itensPedido.add(new ItemPedido(item)));
        return itensPedido;
    }

    public Pedido() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<ItemPedido> getItensPedido() {
        return itensPedido;
    }

    public void setItensPedido(List<ItemPedido> itensPedido) {
        this.itensPedido = itensPedido;
    }

    public LocalDateTime getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(LocalDateTime dataEntrega) {
        this.dataEntrega = dataEntrega;
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
        return "Pedido{" +
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
