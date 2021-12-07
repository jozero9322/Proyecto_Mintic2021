const mongoose = require('mongoose');
const {Schema} = require('mongoose');

let clienteSchema = new Schema({
    cedula: {type:String,required:true, unique: true},
    nombre: {type: String, required:true},
    usuario: {type: String, required:true, unique: true},
    password: {type: String, required:true},
    token: String
});

const Cliente = mongoose.model('Cliente',clienteSchema);

module.exports = Cliente;
