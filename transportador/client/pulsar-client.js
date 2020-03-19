const Pulsar = require('pulsar-client');

const client = new Pulsar.Client({
    serviceUrl: 'pulsar://localhost:6650',
    operationTimeoutSeconds: 30,
  });



module.exports = { client };