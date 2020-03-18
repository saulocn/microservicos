const {port, host, ipAddr} = require('../config/server');
const Eureka = require('eureka-js-client').Eureka;
console.log( `http://${host}:${port}/healthcheck`)
// example configuration
const client = new Eureka({
    // application instance information
    instance: {
        app: 'transportador',
        hostName: host,
        ipAddr: ipAddr,
        port: {
          '$': port,
          '@enabled': true,
        },
        vipAddress: `${host}`,
        healthCheckUrl: `http://${host}:${port}/healthcheck`,
        dataCenterInfo: {
            '@class': 'com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo',
            name: 'MyOwn',
        }
    },
    eureka: {
        host: ipAddr,
        port: 8761,
        servicePath: '/eureka/apps/'
    },
});

client.start();