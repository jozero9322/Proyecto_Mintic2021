import axios from "axios";

const API = "http://localhost:3001";


export default {

    getAll(subdir){
        const aux = `${API}/${subdir}`;
        return axios.get(aux);
    },
    create(subdir, objeto){
        const aux = `${API}/${subdir}`;
        return axios.post(aux,objeto);
    }

};