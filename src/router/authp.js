const isAutenticadop = (origen, destino,accion) =>{
    if(localStorage.cliente && localStorage.usuario=="admin" ){
        accion();
    }else{
            accion({name:"Login"});
    }
  
  }
  export default isAutenticadop;