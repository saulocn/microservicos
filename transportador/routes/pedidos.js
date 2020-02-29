const router   = require('../config/server').server;
const service  = require('../services/pedidos');

router.get('/pedidos', (request, response, next) => {
    service.list()
    .then(pedidos=>response.send(200, pedidos))
    .catch(err=> response.send(500, err));
    next();
});


module.exports = router;