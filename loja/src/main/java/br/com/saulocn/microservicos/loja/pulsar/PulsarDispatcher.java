package br.com.saulocn.microservicos.loja.pulsar;

import com.google.common.base.Throwables;
import org.apache.pulsar.client.api.Producer;
import org.apache.pulsar.client.api.PulsarClientException;
import org.apache.pulsar.client.impl.schema.JSONSchema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PulsarDispatcher<T> {

    private static final Logger LOG = LoggerFactory.getLogger(PulsarDispatcher.class);

    @Autowired
    private PulsarClientSingleton clientSingleton;

    public void send(String topic, Class<T> clazz, T object) {
        try (Producer<T> producer = clientSingleton.getClient().newProducer(JSONSchema.of(clazz))
                .topic(topic).create()) {
            producer.send(object);
        } catch (PulsarClientException e) {
            LOG.error("Erro ao enviar a mensagem para o Pulsar", Throwables.getRootCause(e));
        }
    }


}
