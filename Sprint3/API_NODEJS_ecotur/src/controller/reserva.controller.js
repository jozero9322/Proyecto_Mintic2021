const reservaCtrl = {};
const modelReserva = require('../model/reserva.model');

reservaCtrl.getReservas = async (req, res) => {
    try {
        const reservas = await modelReserva.find({});
        res.status(201).json(reservas);
    } catch (error) {
        console.log(error);
        res.status(400).send("Ocurrio un error en la operación");
    }
};

reservaCtrl.getReserva = async (req, res) => {
    try {
        const reserva = await modelReserva.findOne({id_reserva:req.params.id_reserva});
        if (reserva.length == 0){
            res.send("este paquete no esta en la base de datos")
        } else {
            res.status(201).json(reserva);
        }
    } catch (error) {
        console.log(error);
        res.status(400).send("Ocurrio un error en la operación");
    }
};

reservaCtrl.createReserva = async (req, res) => {
    try {
        const reservaTemp = {
            id_reserva: req.body.id_reserva,
            personas: req.body.personas,
            ninos: req.body.ninos,
            total: req.body.total,
            cliente_cedula: req.body.cliente_cedula,
            paquete_codigo: req.body.paquete_codigo,
        };
        
        let nuevaReserva = new modelReserva(reservaTemp);
        await nuevaReserva.save();
        res.status(201).send("Reserva Creada satisfactoriamente");
    } catch (error) {
        console.log(error);
        res.status(400).send("Ocurrio un error en el servidor");
    }
};

reservaCtrl.editReserva = async (req,res) => {
    try {
        const reservaTemp = {
            id_reserva: req.body.id_reserva,
            personas: req.body.personas,
            ninos: req.body.ninos,
            total: req.body.total,
            cliente_cedula: req.body.cliente_cedula,
            paquete_codigo: req.body.paquete_codigo
        };
        
        await modelReserva.updateOne({id_reserva:req.params.id_reserva},reservaTemp);
        res.status(201).send("Editado satisfactoriamente");
    } catch (error) {
        console.log(error);
        res.status(400).send("Ocurrio un error en el servidor");
    }
};

reservaCtrl.deleteReserva = async (req,res) => {
    try {
        await modelReserva.deleteOne({id_reserva:req.params.id_reserva});
        res.status(201).send("Eliminado satisfactoriamente");
    } catch (error) {
        console.log(error);
        res.status(400).send("Ocurrio un error en el servidor");
    }
};

module.exports = reservaCtrl;