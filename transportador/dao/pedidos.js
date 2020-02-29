const db  = require('../config/db')

function list(){
    return new Promise((resolve, reject)=> {
        const collection = db.get().collection('pedidos');

        collection.find({}).toArray(function(err, pedidos) {
            if(err){
                console.log("err",err)
                reject(err);
            }
            resolve(pedidos)
          });
    })
}

module.exports = {list};