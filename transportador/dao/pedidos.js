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

function get(id) {
    return new Promise((resolve, reject) => {
        const collection = db.get().collection('pedidos');

        collection.findOne({ id: id }, function (err, pedido) {
            if (err) {
                console.error("err", err)
                reject(err);
            }
            resolve(pedido)
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

function update(id, pedido) {
    return new Promise((resolve, reject) => {
        const collection = db.get().collection('pedidos');
        collection.findOneAndUpdate({ id: id }, pedido, function (err, res) {
            if (err) {
                console.error("err", err)
                reject(err);
            }
            console.log("Pedido atualizado!", pedido);
            resolve();
        });
    })
}

function updateStatus(id, status) {
    return new Promise((resolve, reject) => {
        const collection = db.get().collection('pedidos');
        collection.findOneAndUpdate({ id: id },
            { $set: { status } },
            { returnOriginal: false }
            , function (err, pedido) {
                if (err) {
                    console.error("err", err)
                    reject(err);
                }
                console.log("Pedido atualizado!", pedido);
                resolve(pedido.value);
            });
    })
}


module.exports = { list, insert, get, update, updateStatus };