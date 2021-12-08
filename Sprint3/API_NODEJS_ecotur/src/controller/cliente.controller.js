const clienteCtrl = {};
const modelCliente = require('../model/cliente.model');
const jwt = require('jsonwebtoken');


// Get all Clients
clienteCtrl.getClientes = async (req, res) => {
    try {
        const clientes = await modelCliente.find({});
        res.status(200).json(clientes);
    } catch (error) {
        console.log(error);
        res.status(400).send("Ocurrio un error en la operación");
    }
};

// Get only one Client
// este metodo es para encontrar el cliente por cedula
/*
clienteCtrl.getCliente = async (req, res) => {
    
    try {
        const cliente = await modelCliente.findOne({cedula:req.params.cedula});
        if(cliente.legth == 0){
            res.send("Esta cédula no esta en la base de datos");
        } else {
            res.status(200).json(cliente);
        }
    } catch (error) {
        console.log(error);
        res.status(400).send("Ocurrio un error en la operación");
    }
};
*/

// este metodo es para buscar al cliente por usuario y password
clienteCtrl.getCliente = async (req, res) => {
    
    try {
        const {usuario, password} = req.body;
        const buscarUsuario = await modelCliente.findOne({usuario:usuario});
        if(buscarUsuario && password === buscarUsuario.password){

            res.status(201).json(buscarUsuario);

        } else {
            res.send("El Usuario o el Password son incorrectos");
        }


    } catch (error) {
        console.log(error);
        res.status(400).send("Ocurrio un error en la operación");
    }
};


// Create a new Client
clienteCtrl.createCliente = async (req, res) => {
    try {
        const clientTemp = {
            cedula: req.body.cedula,
            nombre: req.body.nombre,
            usuario: req.body.usuario,
            password:req.body.password,
            token: "",
        };
        let nuevoCliente = new modelCliente(clientTemp);
        await nuevoCliente.save();
        res.status(201).send("Se ha creado un cliente nuevo");
    } catch (error) {
        console.log(error);
        res.status(400).send("Ocurrio un error en la operación");
    }
};

// Edit an existing client
clienteCtrl.editCliente = async (req, res) => {
    try {
        const clientTemp = {
            cedula: req.body.cedula,
            nombre: req.body.nombre,
            usuario: req.body.usuario,
            password: req.body.password,
            token: "",
        };
        await modelCliente.updateOne({cedula:req.params.cedula},clientTemp);
        res.status(201).send("El cliente se ha actualizado");

    } catch (error) {
        console.log(error);
        res.status(400).send("Ocurrio un error en la operación");
    }
};

// Delete a client.
clienteCtrl.deleteCliente = async (req, res) => {
    try {
        await modelCliente.deleteOne({cedula:req.params.cedula});
        res.status(201).send("El cliente se ha eliminado correctamente");
    } catch (error) {
        console.log(error);
        res.status(400).send("Ocurrio un error en la operación");
    }
};

// Token: este funciona con Usuario y Password
clienteCtrl.token = async (req, res) => {
    
    try {
        const {usuario, password} = req.body;
        
        if( !(usuario) || !(password) ){
            res.status(400).send("El usuario y el password son requeridos");
        } else {
            
            const cliente_verify = await modelCliente.findOne({usuario:usuario});
            if (cliente_verify && cliente_verify.password === password){

                // usamos una funcion de jsonwebtoken la cual recibe tres parámetros
                // para generar el token.
                // parametro 1: asigno en la varible user_id el valor del id (de la BD) del cliente que me envian
                // parametro 2: clave privada interna del sistema la cual es un String. (.ENV)
                // parametro 3: la duración del token
                const token = jwt.sign({user_id: cliente_verify._id, usuario}, process.env.TOKEN_KEY,{expiresIn:"24h"});
                await modelCliente.updateOne({usuario:usuario},{token: token});
                res.status(201).json(token);
            } else {

                res.status(400).send("Credenciales inválidas");

            }
        }

    } catch (error) {
        console.log(error);
        res.send("Ocurrio un erro al generar el token");
    }
};

/*
// Token: este funciona con la cedula
clienteCtrl.token = async (req, res) => {
    
    try {
        const {cedula} = req.body;
        
        if(!(cedula)){
            res.status(400).send("La cédula es requerida");
        } else {

            const cliente_verify = await modelCliente.findOne({cedula:cedula});
            if (cliente_verify){
                // usamos una funcion de jsonwebtoken la cual recibe tres parámetros
                // para generar el token.
                // parametro 1: asigno en la varible user_id el valor del id (de la BD) del cliente que me envian
                // parametro 2: clave privada interna del sistema la cual es un String. (.ENV)
                // parametro 3: la duración del token
                const token = jwt.sign({user_id: cliente_verify._id, cedula}, process.env.TOKEN_KEY,{expiresIn:"24h"});
                await modelCliente.updateOne({cedula:cedula},{token: token});
                res.status(201).json(token);
            } else {

                res.status(400).send("Credenciales inválidas");

            }
        }

    } catch (error) {
        console.log(error);
        res.send("Ocurrio un erro al generar el token");
    }
};
*/
module.exports = clienteCtrl;