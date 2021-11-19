<template>
<div class="login-page" >
  <div class="form">
    <h1>Inicio de Sesion</h1>
    <form action="#" class="register-form" id="register-form">
      <input type="text" placeholder="Usuario" v-model="usuario"> 
      <input type="password" placeholder="Contraseña" v-model="password">
      
       <button class="btn" @click.prevent="iniciarSesion"><i class="fa fa-unlock"></i></button>
     
       <h2 v-if="error!=''">{{error}}</h2>
    </form>  
  </div>
</div> 
</template>

<script>

import ClientesService from "@/services/clientes.js"

export default {

  data(){
    return {
      usuario:"",
      password:"",
      error:""
    }
  },
  methods:{
    iniciarSesion(){
      ClientesService.validar(this.usuario,this.password).then(
        (respuesta)=>{
          console.log(respuesta.data);
          if(respuesta.data.usuario){
              localStorage.cliente=respuesta.data.documento;
              localStorage.usuario=respuesta.data.usuario;
              error:"Go Home ... usuario logueado...";
              //this.$router.go(0);
              //this.$router.push({name:"home"});
              //this.$router.push({name:"Home"});
              this.error="Usuario: "+localStorage.usuario+" logueado --> Home no funciona router";
          }else{
            this.error="Datos invalidos";
          }
        }
      );

    }
  }
}
</script>
<style>

input[type=text], input[type=password] {
  width: 30%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
  border-radius: 5px;
}

button:hover {
  opacity: 0.8;

}

   #register-form{
          background-image: url("../assets/fondo.jpg");
	        }

</style>
