const {Router} = require('express');
const router = Router();
const auth = require('../auth/auth');

// Get the methos or functions from the cotroller to be used here.
const {getClientes, getCliente,createCliente, editCliente, deleteCliente,token} = require('../controller/cliente.controller');

// Gets all clients
router.get('/clientes',getClientes);

// Gets only one client
router.get('/cliente/:cedula',auth, getCliente);

// Saves one client
router.post('/cliente',createCliente);

// Edits one client
router.put('/cliente/:cedula',editCliente);

// Deletes one client
router.delete('/cliente/:cedula',deleteCliente);

// This route is to generate one token.
// You need to send on the body {"cedula":"22222"}
/*
    {
        "cedula":"22222"
    }
*/
router.post('/cliente/token',token);


// Exports this constant to be used in server.js
module.exports = router;