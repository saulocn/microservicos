package br.com.saulocn.microservicos.loja.pulsar;

import org.apache.pulsar.client.api.Consumer;
import org.apache.pulsar.client.api.Message;
import org.apache.pulsar.client.api.PulsarClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class PedidosConsumer {
    @Autowired
    PulsarClientSingleton pulsarClientSingleton;

    @EventListener(ApplicationReadyEvent.class)
    public void consume() throws PulsarClientException {
        String subscription = "my-subscription";
        Consumer consumer = pulsarClientSingleton.getClient().newConsumer()
                .topic("pedido_entregue")
                .subscriptionName(subscription)
                .subscribe();
        while (true) {
            Message msg = consumer.receive();
            try {
                System.out.printf("Message received: %s", new String(msg.getData()));
                consumer.acknowledge(msg);
            } catch (Exception e) {
                consumer.negativeAcknowledge(msg);
            }
        }
    }

}
