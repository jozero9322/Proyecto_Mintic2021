<template>

    <div class="contenedor__listado">
        <h3>Listado de Paquetes</h3>
        
        <table border="1">
            <thead>
                <tr>
                    <th>Código</th>
                    <th>Nombre</th>
                    <th>Descripción</th>
                    <th>Precio</th>
                    <th>Duración</th>
                    <th>Salida</th>
                </tr>
            </thead>

            <tbody >
                <tr v-for="eachPackage in allPackages" :key="eachPackage">
                    <td>{{eachPackage.codigo}}</td>
                    <td>{{eachPackage.nombre_pac}}</td>
                    <td>{{eachPackage.descripcion}}</td>
                    <td>{{eachPackage.precio}}</td>
                    <td>{{eachPackage.duracion}}</td>
                    <td>{{eachPackage.salida}}</td>
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
            allPackages: [],
        }


    },
    methods: {

    },
    async mounted(){

        const resp = await api.getAll("paquetes");
        this.allPackages = resp.data;
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