<template>
<header>
<h2> {{titulo}}</h2>
</header>
<main>
    
<div class="bg-img">
<h2>Registrar Clientes</h2>
<form id="formulario_cliente" action="#" method="post">
    <label for ="nombre">Documento</label>
<input type="text" name="documemto" v-model="cliente.documento">
<label for ="nombre">Nombre</label>
<input type="text" name="nombre" v-model="cliente.nombre">
<label for ="usuario">Usuario</label>
<input type="text" name="usuario" v-model="cliente.usuario">
<label for ="password">Password</label>
<input type="password" name="password" v-model="cliente.password">

<button type="reset">Limpiar</button>
<button @click="procesarInformacion" type="button">Agregar Cliente</button>
</form>

</div>

<div>
            <h2>Listado de Clientes </h2>
            <table border="1">
                <thead>
                    <tr>
                         <th>Documento</th>
                        <th>Nombre</th>
                       
                        <th>Usuario</th>
                        <th>Password</th>
                
                    </tr>
                </thead>
                <tbody id="datos_cliente">
                   
                       <tr v-for="unCliente in listaClientes" :key="unCliente">
                           <td>{{unCliente.documento}}</td>
                        <td>{{unCliente.nombre}}</td>
                        <td>{{unCliente.usuario}}</td>
                        <td>{{unCliente.password}}</td>
                    </tr>   
                             
                </tbody>
            </table>
        </div>
		
		

</main>
</template>

<script>
import ClienteService from "@/services/clientes.js"

export default {
    mounted(){
      
        ClienteService.obtenerTodos().then((respuesta)=>{
            
            this.listaClientes=respuesta.data;
            
        });
        document.title="Gestion de Clientes";
        
     },
    title:"prueba",
    data(){
      return{
        titulo:"Gestion de Clientes",
        listaClientes:[],
        cliente:{},
         };
  },
  name: 'Reserva',
  methods:{
      procesarInformacion(){
 
           console.log(this.cliente); 
           
          ClienteService.registrar(this.cliente).then((respuesta)=>{
                this.listaClientes.push(this.cliente);
               
          })
        
      }
  }
}
</script>

<style scoped>
     body{
            padding: 2rem;
			
        }
    header {
        display: grid;
            grid-template-columns: 1fr  ;
            background-color: #192954 ;
            text-align: center;
	        text-align:center;font-family: 'Arial', serif;
	        color: whitesmoke;
            font-size: 14px;
            
        }
        #formulario_cliente{
            display: grid;
            grid-template-columns: 5rem 10rem;
            row-gap: 1rem;
            column-gap: 0.5rem;
	        }

        main{
            display: grid;
            grid-template-columns: 1fr 2fr ;
			background-image: url("../assets/fondo.jpg");
			
        }

        table{
            width: 80%;
            margin: 0 auto;
        }

        table td{
            text-align: center;
        }
		
	.button_sesion {border-radius: 25px;}


</style>