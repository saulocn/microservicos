const db = require('../config/db')

function list() {
    return new Promise((resolve, reject) => {
        const collection = db.get().collection('pedidos');

        collection.find({}).toArray(function (err, pedidos) {
            if (err) {
                console.error("err", err)
                reject(err);
            }
            resolve(pedidos)
        });
    })
}

function insert(pedido) {
    return new Promise((resolve, reject) => {
        const collection = db.get().collection('pedidos');
        collection.insertOne(pedido, function (err, res) {
            if (err) {
                console.error("err", err)
                reject(err);
            }
            console.log("Pedido adicionado!", pedido);
            resolve();
        });

    })
}

module.exports = { list, insert };