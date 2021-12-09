<template>

    <div class="contenedor__listado">
        <h3>Listado de Clientes</h3>
        
        <table border="1">
            <thead>
                <tr>
                    <th>Cédula</th>
                    <th>Nombre</th>
                    <th>Usuario</th>
                    <th>Password</th>

                </tr>
            </thead>

            <tbody >
                <tr v-for="eachPackage in allClients" :key="eachPackage">
                    <td>{{eachPackage.cedula}}</td>
                    <td>{{eachPackage.nombre}}</td>
                    <td>{{eachPackage.usuario}}</td>
                    <td>{{eachPackage.password}}</td>

                </tr>   
                            
            </tbody>

        </table>

    </div>

</template>


<script>
import api from "@/logic/api.js";

export default {
    name:"Clientes",
    data: function(){
        return {
            allClients: [],
        }


    },
    methods: {

    },
    async mounted(){

        const resp = await api.getAll("clientes");
        this.allClients = resp.data;
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