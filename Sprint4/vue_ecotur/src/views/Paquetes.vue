<template>
  <div >
    
    <Navegacion/>

    <h1>Gestion de Paquetes</h1>
      <div>
      <fieldset >
          <label for="">
              <input v-on:click="verPaq" type="radio" name="paquete" value="Ver">Ver Paquetes
          </label>
          <label for="">
              <input  v-on:click="crearPaq"  type="radio" name="paquete" value="Crear" >Crear un Paquete
          </label>
          <label for="">
              <input v-on:click="editarPaq" type="radio" name="paquete" value="Editar" >Editar un Paquete
          </label>
          <label for="">
              <input v-on:click="eliminarPaq" type="radio" name="paquete" value="Eliminar" >Eliminar un Paquete
          </label>

      </fieldset>
    </div>

    <PaqueCrear v-if="crear"/>
    <PaqueVer v-if="ver" />
    <PaqueEditar v-if="editar" />
    <PaqueEliminar v-if="eliminar" />

     
  </div>
</template>

<script>
// @ is an alias to /src

import Navegacion from "@/components/Navegacion"
import PaqueCrear from "@/components/PaqueCrear"
import PaqueVer from "@/components/PaqueVer"
import PaqueEditar from "@/components/PaqueEditar"
import PaqueEliminar from "@/components/PaqueEliminar"


export default {
  name: "Paquetes",
  components: {
   Navegacion,
   PaqueCrear,
   PaqueVer,
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
    verPaq(){
      this.ver = true;
      this.crear = false;
      this.editar = false;
      this.eliminar = false;
    },
    crearPaq(){

      this.ver = false;
      this.crear = true;
      this.editar = false;
      this.eliminar = false;
      
    },
    editarPaq(){
      this.ver = false;
      this.crear = false;
      this.editar = true;
      this.eliminar = false;
    },
    eliminarPaq(){
      this.ver = false;
      this.crear = false;
      this.editar = false;
      this.eliminar = true;
    },


  },
};
</script>