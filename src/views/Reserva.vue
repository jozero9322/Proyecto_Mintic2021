<template>
<header>
<h2> {{titulo}}</h2>
</header>
<main>
    
<div class="bg-img">
<h2>Registrar Reserva</h2>
<form id="formulario_reserva" action="#" method="post">

<label for ="paquete">Seleccione Paquete</label>
<div class="paq" style="width:200px;">
<select name="paquete" id="paque" v-model="paquete">
    <option v-for="unPaquete, i in listaPaquetes" :key="unPaquete.id" :value="i">
        {{unPaquete.nombre}}</option>
	</select>
</div>
<input type="checkbox" name="transporte_si" v-model="trans">
<label for ="transporte_si">Incluir trasporte al punto de partida</label>
<input type="checkbox" name="num_personas_si" v-model="perso">
<label for="num_personas_si">Agregar personas o niños extra?</label>
<label v-if="perso" for="num_personas">Numero de  Personas</label>
<input v-if="perso" type="number" name="num_personas" v-model="personas">
<label v-if="perso" for="num_ninos">Numero de Niños</label>
<input v-if="perso" type="number" name="num_ninos" v-model="ninos" >
<button type="reset">Limpiar</button>
<button @click="procesarInformacion" type="button">Agregar Reserva</button>
</form>

</div>

<div>
            <h2>Listado de Paquetes - {{cliente.nombre}}</h2>
            <table border="1">
                <thead>
                    <tr>
                        <th>CLIENTE</th>
                        <th>PAQUETE</th>
                        <th>NIÑOS</th>
                        <th>ADULTOS</th>
                        <th>TOTAL</th>
                    </tr>
                </thead>
                <tbody id="datos_reserva">
                    <tr v-for="unReserva,i  in listaReservas" :key="unReserva">
                        <td>{{unReserva.cliente.nombre}}</td>
                        <td>{{unReserva.paquete.nombre}}, ubicada en : {{unReserva.paquete.ubicacion}},  duracion: {{unReserva.paquete.duracion}} dia (s)</td>
                        <td>{{unReserva.ninos}}</td>
                        <td>{{unReserva.personas}}</td>
                        <td>{{unReserva.total}}</td>
                        <td><button class="btn" @click.prevent="eliminar(unReserva.documento,i,unReserva.id)"><i class="fa fa-trash"></i></button></td>
             
                    </tr>                 
                </tbody>
            </table>
        </div>
		
		

</main>
</template>

<script>

import ReservaService from "@/services/reservas.js"
import PaqueteService from "@/services/paquetes.js"
import ClienteService from "@/services/clientes.js"

export default {
    mounted(){
        ClienteService.obtener().then((respuesta)=>{
            this.cliente=respuesta.data;
        });
        PaqueteService.obtenerTodos().then((respuesta)=>{
            
            this.listaPaquetes=respuesta.data;
            
        });
        document.title="Gestion de Reservas";
        ReservaService.obtenerPorCliente().then((respuesta)=>{
            this.listaReservas=respuesta.data;
        });

      
     },
    title:"prueba",
  data(){
      return{
        titulo:"Gestion de reservas",
        listaPaquetes:[],
        listaReservas:[],
        reserva:{},
        paquete:0,
        perso:false,
        trans:true,
        ninos:0,
        personas:0,
        cliente:{}
              };
  },
  name: 'Reserva',
  components: {
   
  },
  methods:{

      eliminar(docu,position,idr){
          console.log("ID: "+idr);
          this.listaReservas.splice(position,1);
          ReservaService.eliminar(idr).then((respuesta)=>{
                this.limpiarFormulario();
            })
    
      },
      limpiarFormulario(){
          this.reserva= {
          cliente:"",
            documento:"",
            paquete:0,
            personas:0,
            ninos:0,
            total:0
          }
          
      },
      procesarInformacion(){
         
        this.reserva.cliente = this.cliente; 
        this.reserva.paquete = this.listaPaquetes[this.paquete];
                  
         if (this.perso){
              this.reserva.personas=this.personas+1;
         } else {
              this.reserva.personas=1;
          }
      
        this.reserva.ninos=this.ninos;
          
        this.reserva.total=this.reserva.paquete.precio*(this.reserva.personas+this.reserva.ninos);
              
           
         
           console.log(this.reserva); 
           
          ReservaService.registrar(this.reserva).then((respuesta)=>{
                this.listaReservas.push(this.reserva);
               this.limpiarFormulario();
          })
         
         
          

          
          //this.$router.push({name:"Home",params:{datos:this.listaReservas}});
          
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
        #formulario_reserva{
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