<template>
    <div>
        <Navegacion/>
        

        <label for="">Cedula de Ciudadania</label>
        <input type="text" v-on:input=" entrada = $event.target.value">
        <button @click="verificar">Verificar</button>
    </div>
</template>

<script>
// @ is an alias to /src
import api from "@/logic/api.js"
import auth from "@/logic/autenticacion.js"
import Navegacion from "@/components/Navegacion.vue";


export default {
  name: "Login",
  components: {
    Navegacion,
  },
  data: function () {
    return {
      entrada:"",
    }
  },
  methods: {
    async verificar(){
      try {
        let obj_temp ={cedula: this.entrada}
        let respuesta = await api.token(obj_temp);
        auth.createToken(respuesta.data);
        alert(auth.getToken());
      } catch (error) {
        console.log(error);
      }

      
    }
  },

};
</script>