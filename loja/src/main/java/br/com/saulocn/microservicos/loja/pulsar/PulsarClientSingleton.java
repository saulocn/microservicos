package br.com.saulocn.microservicos.loja.pulsar;

import java.io.Closeable;
import java.io.IOException;

import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.PulsarClientException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PulsarClientSingleton implements Closeable {

    PulsarClient client;

    public PulsarClientSingleton(@Value("${pulsar.url}") String url, @Value("${pulsar.port}") String port) throws PulsarClientException {
        this.client = org.apache.pulsar.client.api.PulsarClient.builder()
                .serviceUrl(String.format("pulsar://%s:%s", url, port))
                .build();
    }

    public PulsarClient getClient() {
        return client;
    }

    @Override
    public void close() throws IOException {
        client.close();
    }
}
