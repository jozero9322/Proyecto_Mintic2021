import axios from "axios";

const API = "http://localhost:3001";


export default {

    getAll(subdir){
        const aux = `${API}/${subdir}`;
        return axios.get(aux);
    },
    getOne(subdir){
        const aux = `${API}/${subdir}`;
        return axios.get(aux);
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
    token(param){
        // http://dominio/cliente/token
        const aux = `${API}/cliente/token`;
        return axios.post(aux, param);
    },

};