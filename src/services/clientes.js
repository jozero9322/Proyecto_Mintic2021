import axios  from "axios";

class ClienteService{
    url="http://localhost:8080/cliente";
    //url="http://132.145.72.108:8080/cliente";

    validar(miUsuario,miPassword){
        let datos = {usuario:miUsuario, password:miPassword};
        return axios.post(`${this.url}/validar`,datos);
    }

    obtener(documento){
         documento=localStorage.cliente;
        return axios.get(`${this.url}/${documento}`);
    }

    obtenerTodos(){
        return axios.get(`${this.url}/todos`);
     }
     registrar(cliente){
      return axios.post(`${this.url}`,cliente);
    }
}

export default new ClienteService();