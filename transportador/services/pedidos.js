const dao  = require('../dao/pedidos');

function list(){
    return dao.list()
}

function insert(pedido){
    return dao.insert(pedido)
}

module.exports = {list, insert};