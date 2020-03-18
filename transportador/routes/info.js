const router   = require('../config/server').server;

router.get('/info', (request, response, next) => {
    const upMsg = {status: "UP"}
    response.send(200, upMsg)
});

router.get('/healthcheck', (request, response, next) => {
    const upMsg = {status: "UP"}
    response.send(200, upMsg)
});


module.exports = router;