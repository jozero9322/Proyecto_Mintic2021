const mongoose = require('mongoose');
const {Schema} = require('mongoose');

let clienteSchema = new Schema({
    cedula: {type:String,required:true, unique: true},
    nombre: {type: String, required:true},
    usuario: {type: String, required:true},
    password: {type: String, required:true},
});

const Cliente = mongoose.model('Cliente',clienteSchema);

module.exports = Cliente;
