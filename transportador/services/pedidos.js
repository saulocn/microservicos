const dao  = require('../dao/pedidos');
const producer  = require('../client/pedidos-producer');

function list(){
    return dao.list()
}

function get(id){
    return dao.get(id)
}

function update(id, pedido){
    return dao.update(id, pedido)
}

function insert(pedido){
    return dao.insert(pedido)
}

function efetuaEntrega(id){
    return new Promise((resolve, reject)=>{
        dao.updateStatus(id, "ENTREGUE")
        .then(pedido=>{
            producer.sendPedido("pedido_entregue", pedido)
            resolve(pedido);
        })
        .catch(resolve)
    })
}

function iniciaEntrega(id){
    return dao.updateStatus(id, "EM_TRANSITO")
}

function entragaNaoRealizada(id){
    return dao.updateStatus(id, "ENTREGA_NAO_REALIZADA")
}

module.exports = {list, insert, get, update, efetuaEntrega, iniciaEntrega, entragaNaoRealizada};