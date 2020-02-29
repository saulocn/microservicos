const dao  = require('../dao/pedidos');

function list(){
    return dao.list()
}

module.exports = {list};