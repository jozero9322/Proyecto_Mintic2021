<template>
<div>

    <div class="contenedor">
        <div>
            <h3>Crear Paquetes</h3>
            <form class="formulario__registro" action="#">

                <label class="formulario__registro-inputs" for="codigo">Código</label>
                <input class="formulario__registro-inputs" required type="text" placeholder="Código" id="codigo">

                <label class="formulario__registro-inputs" for="nombre_pac">Nombre del Paquete</label>
                <input class="formulario__registro-inputs" required type="text" placeholder="Nombre del Paquete" id="nombre_pac">

                <label class="formulario__registro-inputs" for="ubicacion">Descripcion</label>
                <input class="formulario__registro-inputs" required type="text" placeholder="Descripcion" id="descripcion">

                <label class="formulario__registro-inputs" for="precio">Precio</label>
                <input class="formulario__registro-inputs" required type="text" placeholder="Precio" id="precio">

                <label class="formulario__registro-inputs" for="duracion">Duracion (dias)</label>
                <input class="formulario__registro-inputs" required type="text" placeholder="Duración" id="duracion">

                <label class="formulario__registro-inputs" for="salida">Salida</label>
                <input class="formulario__registro-inputs" required type="text" placeholder="Salida" id="salida">


            </form>
            <div class="formulario-botones">  
                <button type="button" @click="limpiar">Limpiar</button>
                <button type="button" @click="agregarPaquete">Crear Paquete</button>

            </div>
        </div>
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
    </div>
</div>
</template>


<script>
import api from "@/logic/api.js";

export default {
    name:"Paquetes",
    data: function(){
        return {
            allPackages: [],
            picked:"",
            ver: "",
            agregar: "",
            editar: "",
            eliminar: "",
        }


    },
    methods: {

        async agregarPaquete(){
            const _codigo = document.getElementById('codigo').value;
            const _nombre_pac = document.getElementById('nombre_pac').value;
            const _descripcion = document.getElementById('descripcion').value;
            const _precio = document.getElementById('precio').value;
            const _duracion = document.getElementById('duracion').value;
            const _salida = document.getElementById('salida').value;

            if ( _codigo != "" && _nombre_pac != "" && _descripcion != "" && _duracion != "" && _salida != ""  && _precio != "") {
                await api.create("paquete",{codigo:_codigo, nombre_pac:_nombre_pac, descripcion: _descripcion, precio: _precio, duracion:_duracion, salida:_salida});
                this.actualiza();
            } else {
                alert('Ingrese todos los datos');
            }         
        },
        limpiar(){
            document.getElementById('codigo').value = "";
            document.getElementById('nombre_pac').value = "";
            document.getElementById('descripcion').value = "";
            document.getElementById('precio').value = "";
            document.getElementById('duracion').value = "";
            document.getElementById('salida').value = "";
        },
        async actualiza(){
            const resp = await api.getAll("paquetes");
            this.allPackages = resp.data;
    }

    },
    async mounted(){

        const resp = await api.getAll("paquetes");
        this.allPackages = resp.data;
    },

}

</script>



<style scoped>
.contenedor{
    display: grid;
    grid-template-columns: 1fr 1.5fr;
}
.formulario__registro{
    display: grid;
    grid-template-columns: 1fr 1fr;
    background-color: rgb(213, 211, 208);
    padding: 10px;
    border-radius: 5px;
    margin-left: 40px;

}
.formulario__registro-inputs{
    padding: 2px;
    margin: 5px;
}
.formulario-botones{
    display: flex;
    justify-content: space-between;
    margin-top: 10px;
    margin-left: 40px;
}
.contenedor__listado {
    align-items: center;
    margin: 0 auto;
}
</style>