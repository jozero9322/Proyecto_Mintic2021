import axios from "axios";

const API = "http://localhost:3001";


export default {
    // en este metodo se cambio el get al post para poder enviar un json
    // porque lo que se va a enviar el es token y no queremos el token quede expuesto en la url.
    getAll(subdir, objeto){
        const aux = `${API}/${subdir}`;
        return axios.post(aux, objeto);
    },
    getOne(subdir, objeto){
        const aux = `${API}/${subdir}`;
        return axios.post(aux, objeto);
    },
    create(subdir, objeto){
        const aux = `${API}/${subdir}`;
        return axios.post(aux,objeto);
    },
    edit(subdir,objeto){
        const aux = `${API}/${subdir}`;
        return axios.put(aux,objeto);
    },
    delete(subdir){
        const aux = `${API}/${subdir}`;
        return axios.delete(aux);
    },
    token(objeto){
        // esta funcion es para obtener el token del cliente en la base de datos
        // para lograr esto le envio la ruta y un objeto
        // http://dominio/cliente/token
        const aux = `${API}/cliente/token`;
        return axios.post(aux, objeto);
    },

};