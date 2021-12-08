<template>

    <div class="contenedor__listado">
        <h3>Listado de Reservas</h3>
        
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Personas</th>
                    <th>Niños</th>
                    <th>Total</th>
                    <th>Cedula Cliente</th>
                    <th>Codigo Paquete</th>
                </tr>
            </thead>

            <tbody >
                <tr v-for="eachPackage in allReservations" :key="eachPackage">
                    <td>{{eachPackage.id_reserva}}</td>
                    <td>{{eachPackage.personas}}</td>
                    <td>{{eachPackage.ninos}}</td>
                    <td>{{eachPackage.total}}</td>
                    <td>{{eachPackage.cliente_cedula}}</td>
                    <td>{{eachPackage.paquete_codigo}}</td>
                    
                </tr>   
                            
            </tbody>

        </table>

    </div>

</template>


<script>
import api from "@/logic/api.js";

export default {
    name:"Paquetes",
    data: function(){
        return {
            allReservations: [],
        }


    },
    methods: {

    },
    async mounted(){

        const resp = await api.getAll("reservas");
        this.allReservations = resp.data;
    },

}

</script>



<style scoped>

.contenedor__listado {
    width: 50%;
    margin: 0 auto;
    align-items: center;
}
table{
    margin: 0 auto;
}
</style>