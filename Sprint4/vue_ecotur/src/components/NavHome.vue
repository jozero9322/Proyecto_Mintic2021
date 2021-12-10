<template>
  <nav class="navegacion">
    <!--
    <li><router-link v-show="!registrado" to="/login">Inicio de Sesión</router-link></li>
    <li><router-link @click = "salir()">Cerrar Sesión</router-link></li>
    -->
    <button class="boton" @click="salir()">Home</button>
    <button class="boton" @click="inicio()">Inicio de Sesion</button>
    
    <!-- <button class="boton" @click="salir()">Cerrar</button> -->
    <!-- <button class="boton" @click="paquetes()">Ver Paquetes</button> -->
  </nav>
</template>



<script>
import auth from "@/logic/autenticacion.js"
export default {
  name: "NavHome",
  data: function () {
    return {
      registrado:true,
    };
  },
  methods: {
    verificar(){
      const respuesta = auth.getToken();
      if ( respuesta ){
        this.registrado = true;
      } 
    },
    paquetes(){
      this.$router.push({path:'listado-paquetes'});
    },
    inicio(){
      this.$router.push({path:'login'});
    },
    salir(){
      localStorage.clear();
      this.registrado = false;
      this.$router.push({path:'Index'});
    }
  },
  mounted(){
    this.verificar();
  }
};
</script>

<style scoped>
.navegacion {
  display: flex;
  justify-content: flex-end;
  list-style-type: none;
}
.boton {
  width: max-content;
  padding: 8px;
  margin-right: 2px;
  background-color: rgb(184, 174, 174);
}
</style>
