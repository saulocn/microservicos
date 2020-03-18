const Pulsar = require('pulsar-client');
const service  = require('../services/pedidos');

(async () => {
  // Create a client
  const client = new Pulsar.Client({
    serviceUrl: 'pulsar://localhost:6650',
    operationTimeoutSeconds: 30,
  });

  // Create a consumer
  const consumer = await client.subscribe({
    topic: 'persistent://public/default/pedidos',
    subscription: 'sub1',
    subscriptionType: 'Shared',
    ackTimeoutMs: 10000,
  });

  // Receive messages
  for (let i = 0; i < 10; i += 1) {
    const msg = await consumer.receive();
    const pedido = JSON.parse(msg.getData().toString())
    console.log(pedido);
    service.insert(pedido)
    consumer.acknowledge(msg);
  }

  await consumer.close();
  await client.close();
})();