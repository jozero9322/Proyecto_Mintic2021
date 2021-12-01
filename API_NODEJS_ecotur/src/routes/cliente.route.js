const {Router} = require('express');
const router = Router();

// Get the methos or functions from the cotroller to be used here.
const {getClientes, getCliente,createCliente, editCliente, deleteCliente} = require('../controller/cliente.controller');

// Gets all clients
router.get('/clientes',getClientes);

// Gets only one client
router.get('/cliente',getCliente);

// Saves one client
router.post('/cliente',createCliente);

// Edits one client
router.put('/cliente',editCliente);

// Deletes one client
router.delete('/cliente',deleteCliente);


// Exports this constant to be used in server.js
module.exports = router;