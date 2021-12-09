<template>
  <div >
    
    <Navegacion/>

    <h1>Gestion de Clientes</h1>
      <div>
      <fieldset >
          <label for="">
              <input v-on:click="verCliente" type="radio" name="cliente" value="Ver">Ver Clientes
          </label>
          <label for="">
              <input  v-on:click="crearCliente"  type="radio" name="cliente" value="Crear" >Crear una Cliente
          </label>
          <label for="">
              <input v-on:click="editarCliente" type="radio" name="cliente" value="Editar" >Editar una Cliente
          </label>
          <label for="">
              <input v-on:click="eliminarCliente" type="radio" name="cliente" value="Eliminar" >Eliminar una Cliente
          </label>

      </fieldset>
    </div>

    <ClienteCrear v-if="crear"/>
    <ClienteVer v-if="ver" />
    <ClienteEditar v-if="editar" />
    <ClienteEliminar v-if="eliminar" />

     
  </div>
</template>

<script>
// @ is an alias to /src

import Navegacion from "@/components/Navegacion"
import ClienteCrear from "@/components/ClienteCrear"
import ClienteVer from "@/components/ClienteVer"
import ClienteEditar from "@/components/ClienteEditar"
import ClienteEliminar from "@/components/ClienteEliminar"


export default {
  name: "Clientes",
  components: {
   Navegacion,
   ClienteCrear,
   ClienteVer,
   ClienteEditar,
   ClienteEliminar,
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