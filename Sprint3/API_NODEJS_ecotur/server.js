const express = require('express');
const app = express();
const bodyParser = require('body-parser');

app.use(bodyParser.json());

// Rutas
// aca le digo que use el archivo donde estan guardadas las rutas 
app.use(require('./src/routes/main.route'));
app.use(require('./src/routes/cliente.route'));
app.use(require('./src/routes/package.route'));
app.use(require('./src/routes/reserva.route'));

module.exports = app;