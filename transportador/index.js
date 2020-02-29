const server = require('./config/server').server;
const port = require('./config/server').port;
const db = require('./config/db');
const router = require('./routes/router');

db.connect(() => {
    server.listen(port, (router) => {
        console.log(`restify executando na porta:${port}`);
    });
});