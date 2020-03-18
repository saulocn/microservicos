package br.com.saulocn.microservicos.loja.pulsar;

import java.io.Closeable;
import java.io.IOException;

import com.google.common.base.Throwables;
import org.apache.pulsar.client.api.Producer;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.PulsarClientException;
import org.apache.pulsar.client.impl.schema.JSONSchema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PulsarDispatcher<T> implements Closeable {

    private static final Logger LOG = LoggerFactory.getLogger(PulsarDispatcher.class);

    private String url;

    private String port;

    PulsarClient client;

    public PulsarDispatcher(@Value("${pulsar.url}") String url, @Value("${pulsar.port}") String port) throws PulsarClientException {
        this.url = url;
        this.port = port;
        this.client = PulsarClient.builder()
                .serviceUrl(String.format("pulsar://%s:%s", url, port))
                .build();
    }

    public void send(String topic, Class<T> clazz, T object) {
        try (Producer<T> producer = client.newProducer(JSONSchema.of(clazz))
                .topic(topic).create()) {
            producer.send(object);
        } catch (PulsarClientException e) {
            LOG.error("Erro ao enviar a mensagem para o Pulsar", Throwables.getRootCause(e));
        }
    }


    @Override
    public void close() throws IOException {
        client.close();
    }
}
