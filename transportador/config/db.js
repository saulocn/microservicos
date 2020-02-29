const mongoClient = require('mongodb').MongoClient;
const mongoDbUrl = 'mongodb://root:root@localhost:27017';
const dbName = 'pedidos'
const mongoOpts = {
    useNewUrlParser: true,
    useUnifiedTopology: true
}
let mongodb;

function connect(callback) {
    mongoClient.connect(mongoDbUrl, mongoOpts, (err, db) => {
        if(err){
            return console.log("Erro ao se conectar ao banco de dados: ", err)
        }
        mongodb = db.db(dbName);
        callback();
    });
}
function get() {
    return mongodb;
}

function close() {
    mongodb.close();
}

module.exports = {
    connect,
    get,
    close
};

