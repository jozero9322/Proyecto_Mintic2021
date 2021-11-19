<template>

  <div>

<h2>Listado de Paquetes</h2>
            <table border="1">
                <thead>
                    <tr>
                        <th>PAQUETE</th>
                        <th>Precio</th>
                        <th>horario</th>
                        <th>ubicacion</th>
                    </tr>
                </thead>
                <tbody id="datos_paquete">
                    <tr v-for="unPaquete in listaPaquetes" :key="unPaquete">
                        <td>{{unPaquete.nombre}}</td>
                        <td>{{unPaquete.precio}}</td>
                        <td>{{unPaquete.horario}}</td>
                        <td>{{unPaquete.ubicacion}}</td>
                        
                    </tr>                 
                </tbody>
            </table>

        
  </div>


</template>

<script>


import PaqueteService from "@/services/paquetes.js"

export default {
    mounted(){
        document.title="Acerca de";
        //this.listaReservas=ReservaService.obtenerTodos();
        PaqueteService.obtenerTodos().then(
            (respuesta)=>{
                console.log(respuesta.data);
                this.listaPaquetes=respuesta.data;
            }
        ).catch(
              (error)=>{

              }  
        
        )
    },
    title:"prueba",
  data(){
      return{
        titulo:"Gestion de reservas",
        //listaPaquetes : ["Sierra Nevada", "Nevado del Ruiz","Salamina","Parque Natural Chicaque","Bioparque La Reserva"],
        listaPaquetes: [],
               
              };
  },
  name: 'Paquete',
  components: {
   
  },
  methods:{

  }
}
</script>
