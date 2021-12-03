const mongoose = require('mongoose');
const {Schema} = require('mongoose');

let reservaSchema = new Schema({
    id_reserva:{type:String,required:true},
    personas: {type:String, required:true},
    ninos: {type:String, required:true},
    total: {type:String, required:true},
    cliente_cedula: {type:String, required:true},
    paquete_codigo: {type:String, required:true}
});

const Reserva = mongoose.model('Reserva',reservaSchema);

module.exports = Reserva;