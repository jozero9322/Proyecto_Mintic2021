const {Router} = require('express');
const router = Router();
const auth = require('../auth/auth');

// Get the methos or functions from the cotroller to be used here.
const {getClientes, getCliente,createCliente, editCliente, deleteCliente,token} = require('../controller/cliente.controller');

// This route is to generate one token.
router.post('/cliente/token',token);
// You need to send on the body {"cedula":"22222"} 
/*
    {
        "cedula":"22222"
    }
*/

// Gets all clients
router.post('/clientes', auth, getClientes);

// Gets only one client
router.post('/cliente/:cedula', auth, getCliente);

//router.get('/cliente',getClienteLogin);

// Creates one client
router.post('/cliente',createCliente);

// Edits one client
router.put('/cliente/:cedula', auth, editCliente);

// Deletes one client
router.delete('/cliente/:cedula',  deleteCliente);





// Exports this constant to be used in server.js
module.exports = router;