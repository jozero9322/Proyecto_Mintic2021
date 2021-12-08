<template>
  <div >
    
    <Navegacion/>

    <h1>Gestion de Reservas</h1>
      <div>
      <fieldset >
          <label for="">
              <input v-on:click="verReser" type="radio" name="reserva" value="Ver">Ver Reservas
          </label>
          <label for="">
              <input  v-on:click="crearReser"  type="radio" name="reserva" value="Crear" >Crear una Reserva
          </label>
          <label for="">
              <input v-on:click="editarReser" type="radio" name="reserva" value="Editar" >Editar una Reserva
          </label>
          <label for="">
              <input v-on:click="eliminarReser" type="radio" name="reserva" value="Eliminar" >Eliminar una Reserva
          </label>

      </fieldset>
    </div>

    <ReserCrear v-if="crear"/>
    <ReserVer v-if="ver" />
    <PaqueEditar v-if="editar" />
    <PaqueEliminar v-if="eliminar" />

     
  </div>
</template>

<script>
// @ is an alias to /src

import Navegacion from "@/components/Navegacion"
import ReserCrear from "@/components/ReserCrear"
import ReserVer from "@/components/ReserVer"
import PaqueEditar from "@/components/PaqueEditar"
import PaqueEliminar from "@/components/PaqueEliminar"


export default {
  name: "Paquetes",
  components: {
   Navegacion,
   ReserCrear,
   ReserVer,
   PaqueEditar,
   PaqueEliminar,
  },
  data:function(){

    return {
      crear: false,
      ver:false,
      editar: false,
      eliminar:false,

    }

  },
  methods: {
    verReser(){
      this.ver = true;
      this.crear = false;
      this.editar = false;
      this.eliminar = false;
    },
    crearReser(){

      this.ver = false;
      this.crear = true;
      this.editar = false;
      this.eliminar = false;
      
    },
    editarReser(){
      this.ver = false;
      this.crear = false;
      this.editar = true;
      this.eliminar = false;
    },
    eliminarReser(){
      this.ver = false;
      this.crear = false;
      this.editar = false;
      this.eliminar = true;
    },


  },
};
</script>