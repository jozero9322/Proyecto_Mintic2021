import axios from "axios";

class ReservaService{
  reservas=[];
  reservaActual={};
  url="http://localhost:8080/reserva";
  //url="http://132.145.72.108:8080/reserva";
  constructor(){

    this.reservaActual={
        cliente:"",
        documento:"",
        paquete:"",
        personas:0,
        ninos:0,
        total:0
   };

     this.reservas=[
        
            {
            cliente:"Maria",
            documento:"3333333",
            paquete:"Sierra Nevada",
            personas:2,
            ninos:0,
            transporte:50000,
            total:700000
            },
             {
            cliente:"Laura",
            documento:"123456789",
            paquete:"Sierra Nevada",
            personas:1,
            ninos:0,
            transporte:0,
            total:300000
            },
        ];

  }

  obtenerTodos(){
      return this.reservas;
  }

  obtenerPorCliente(){
    let documento=localStorage.cliente;
    return axios.get(`${this.url}/cliente/${documento}`)
  }

  obtenerReservaActual(){
    return this.reservaActual;
  }

  registrar(reserva){
    return axios.post(`${this.url}`,reserva);
  }

  eliminar(idr){
    return axios.delete(`${this.url}/borrar/${idr}`);
  }
}export default new ReservaService();