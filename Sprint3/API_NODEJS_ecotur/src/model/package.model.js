const mongoose = require('mongoose');
const {Schema} = require('mongoose');

let packageSchema = new Schema({
    codigo: {type:String,required:true, unique: true},
    nombre_pac: {type: String, required:true},
    descripcion: {type: String, required:true},
    precio: {type: String, required:true},
    duracion: {type: String, required:true},
    salida: {type: String, required:true},
});

const Packege = mongoose.model('Packege',packageSchema);

module.exports = Packege;