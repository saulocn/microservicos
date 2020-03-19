const router   = require('../config/server').server;
const service  = require('../services/pedidos');

router.get('/pedidos', (request, response, next) => {
    service.list()
    .then(pedidos=>response.send(200, pedidos))
    .catch(err=> response.send(500, err));
    next();
});

router.put('/pedidos/efetua-entrega/:id', (request, response, next) => {
    const id = request.params.id;
    service.efetuaEntrega(id)
    .then(pedido =>response.send(200, pedido))
    .catch(err=> {
        console.log("Erro ao efetuar a entrega:", err)
        response.send(500)
    });
    next();
});

router.get('/pedidos/:id', (request, response, next) => {
    const id = request.params.id;
    console.log("Obtendo o pedido", id)
    service.get(id)
    .then(pedidos=>response.send(200, pedidos))
    .catch(err=> response.send(500, err));
    next();
});


module.exports = router;