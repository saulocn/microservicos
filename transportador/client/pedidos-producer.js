
const client = require('./pulsar-client').client;

const sendPedido = async (topic, pedido) => {
    const producer = await client.createProducer({
        topic: `persistent://public/default/${topic}`,
        sendTimeoutMs: 30000,
        batchingEnabled: true,
      });

      producer.send({
        data: Buffer.from(JSON.stringify(pedido)),
      });
      await producer.flush();
}


module.exports = { sendPedido };