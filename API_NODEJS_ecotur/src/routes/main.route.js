const {Router} = require('express');
const router = Router();

// (main) esta funcion  debe ser importada para poderla usar
const {main} = require('../controller/main.controller');

// aca le digo que cuando se solicite la ruta "/" por el verbo GET ejecute la funcion main
// la cual ha sido importada y esta implementada en la ruta: '../controller/main.controller'
router.get('/',main);

// Exports this constant to be used in server.js
module.exports = router;