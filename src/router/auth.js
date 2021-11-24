const isAutenticado = (origen, destino,accion) =>{
  if(localStorage.cliente){
      accion();
  }else{
          accion({name:"Login"});
  }

}
export default isAutenticado;


