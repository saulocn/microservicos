const client = require('./pulsar-client').client;
const service  = require('../services/pedidos');

(async () => {
 
  const consumer = await client.subscribe({
    topic: 'persistent://public/default/pedidos',
    subscription: 'sub1',
    subscriptionType: 'Shared',
    ackTimeoutMs: 10000,
  });

  for (let i = 0; i < 10; i += 1) {
    const msg = await consumer.receive();
    const pedido = JSON.parse(msg.getData().toString())
    console.log(pedido);
    service.insert(pedido)
    consumer.acknowledge(msg);
  }

  await consumer.close();

})();