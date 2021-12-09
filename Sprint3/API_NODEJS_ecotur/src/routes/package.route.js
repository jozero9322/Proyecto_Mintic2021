const {Router} = require('express');
const router = Router();
const auth = require('../auth/auth');

// Get the methos or functions from the cotroller to be used here.
const {getPaquetes,getPaquete,createPaquete,editPaquete,deletePaquete} = require('../controller/package.controller');

// Gets all packages
router.post('/paquetes', auth, getPaquetes);

// Gets only one package
router.post('/paquete/:codigo', auth, getPaquete);

// Saves one client
router.post('/paquete', auth, createPaquete);

// Edits one client
router.put('/paquete/:codigo',editPaquete);

// Deletes one client
router.delete('/paquete/:codigo',deletePaquete);


// Exports this constant to be used in server.js
module.exports = router;