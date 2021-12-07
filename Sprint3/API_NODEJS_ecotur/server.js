const express = require('express');
const app = express();
const bodyParser = require('body-parser');

// espo para las peticiones y solicitudes http
const cors = require('cors');

app.use(bodyParser.json());
app.use((req, res, next) =>{
    // Dominio que tenga acceso /ej 'htttp://example.com')
    res.setHeader('Access-Control-Allow-Origin', '*');
    // Metodos de solicitud que deseas permitir
    res.setHeader('Access-Control-Allow-Methods', 'GET, POST, PUT, DELETE');
    // Encabezados que permites (ej. 'X-Requested-With, content-type')
    res.setHeader('Access-Control-Allow-Headers', '*');
    next();
});
app.use(cors());

// Rutas
// aca le digo que use el archivo donde estan guardadas las rutas 
app.use(require('./src/routes/main.route'));
app.use(require('./src/routes/cliente.route'));
app.use(require('./src/routes/package.route'));
app.use(require('./src/routes/reserva.route'));

module.exports = app;