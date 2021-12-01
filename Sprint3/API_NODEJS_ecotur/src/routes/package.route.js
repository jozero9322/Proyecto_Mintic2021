const {Router} = require('express');
const router = Router();

// Get the methos or functions from the cotroller to be used here.
const {getPaquetes,getPaquete,createPaquete,editPaquete,deletePaquete} = require('../controller/package.controller');

// Gets all clients
router.get('/paquetes',getPaquetes);

// Gets only one client
router.get('/paquete/:codigo',getPaquete);

// Saves one client
router.post('/paquete',createPaquete);

// Edits one client
router.put('/paquete/:codigo',editPaquete);

// Deletes one client
router.delete('/paquete/:codigo',deletePaquete);


// Exports this constant to be used in server.js
module.exports = router;