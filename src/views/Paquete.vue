<template>
<header>
<h2> {{titulo}}</h2>
</header>
<main>
    
<div class="bg-img">
<h2>Registrar Paquetes</h2>
<form id="formulario_paquete" action="#" method="post">
<label for ="nombre">Descripcion del Paquete</label>
<input type="text" name="nombre" v-model="paquete.nombre">
<label for ="ubicacion">Ubicacion</label>
<input type="text" name="ubicacion" v-model="paquete.ubicacion">
<label for="dias">Duracion (dias)</label>
<input type="number" name="dias" v-model="paquete.duracion">
<label for="salida">Salida</label>
<input type="text" name="salida" v-model="paquete.salida">
<label for="precio">Precio</label>
<input type="number" name="precio" v-model="paquete.precio">

<button type="reset">Limpiar</button>
<button @click="procesarInformacion" type="button">Agregar Paquete</button>
</form>

</div>

<div>
            <h2>Listado de Paquetes </h2>
            <table border="1">
                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Ubicacion</th>
                        <th>Precio</th>
                        <th>Duracion</th>
                        <th>Salida</th>
                    </tr>
                </thead>
                <tbody id="datos_paquete">
                   
                       <tr v-for="unPaquete in listaPaquetes" :key="unPaquete">
                        <td>{{unPaquete.nombre}}</td>
                        <td>{{unPaquete.ubicacion}}</td>
                        <td>{{unPaquete.precio}}</td>
                        <td>{{unPaquete.duracion}}</td>
                        <td>{{unPaquete.salida}}</td>
                        
                        
                    </tr>   
                             
                </tbody>
            </table>
        </div>
		
		

</main>
</template>

<script>
import PaqueteService from "@/services/paquetes.js"

export default {
    mounted(){
      
        PaqueteService.obtenerTodos().then((respuesta)=>{
            
            this.listaPaquetes=respuesta.data;
            
        });
        document.title="Gestion de Paquetes";
        
     },
    title:"prueba",
    data(){
      return{
        titulo:"Gestion de Paquetes",
        listaPaquetes:[],
        paquete:{},
         };
  },
  name: 'Reserva',
  methods:{
      procesarInformacion(){
 
           console.log(this.paquete); 
           
          PaqueteService.registrar(this.paquete).then((respuesta)=>{
                this.listaPaquetes.push(this.paquete);
               
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
        #formulario_paquete{
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