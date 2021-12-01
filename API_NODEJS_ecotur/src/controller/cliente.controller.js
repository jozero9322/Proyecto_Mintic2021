const clienteCtrl = {};
const modelCliente = require('../model/cliente.model');

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

// Create a new Client
clienteCtrl.createCliente = async (req, res) => {
    try {
        const clientTemp = {
            cedula: req.body.cedula,
            nombre: req.body.nombre,
            usuario: req.body.usuario,
            password:req.body.password,
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

module.exports = clienteCtrl;