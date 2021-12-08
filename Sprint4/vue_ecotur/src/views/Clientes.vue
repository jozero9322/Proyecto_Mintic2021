<template>
  <div >
    
    <Navegacion/>

    <h1>Gestion de Clientes</h1>
      <div>
      <fieldset >
          <label for="">
              <input v-on:click="verCliente" type="radio" name="reserva" value="Ver">Ver Reservas
          </label>
          <label for="">
              <input  v-on:click="crearCliente"  type="radio" name="reserva" value="Crear" >Crear una Reserva
          </label>
          <label for="">
              <input v-on:click="editarCliente" type="radio" name="reserva" value="Editar" >Editar una Reserva
          </label>
          <label for="">
              <input v-on:click="eliminarCliente" type="radio" name="reserva" value="Eliminar" >Eliminar una Reserva
          </label>

      </fieldset>
    </div>

    <ReserCrear v-if="crear"/>
    <ClienteVer v-if="ver" />
    <ReserEditar v-if="editar" />
    <ReserEliminar v-if="eliminar" />

     
  </div>
</template>

<script>
// @ is an alias to /src

import Navegacion from "@/components/Navegacion"
import ReserCrear from "@/components/ReserCrear"
import ClienteVer from "@/components/ClienteVer"
import ReserEditar from "@/components/ReserEditar"
import ReserEliminar from "@/components/ReserEliminar"


export default {
  name: "Clientes",
  components: {
   Navegacion,
   ReserCrear,
   ClienteVer,
   ReserEditar,
   ReserEliminar,
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
    verCliente(){
      this.ver = true;
      this.crear = false;
      this.editar = false;
      this.eliminar = false;
    },
    crearCliente(){

      this.ver = false;
      this.crear = true;
      this.editar = false;
      this.eliminar = false;
      
    },
    editarCliente(){
      this.ver = false;
      this.crear = false;
      this.editar = true;
      this.eliminar = false;
    },
    eliminarCliente(){
      this.ver = false;
      this.crear = false;
      this.editar = false;
      this.eliminar = true;
    },


  },
};
</script>