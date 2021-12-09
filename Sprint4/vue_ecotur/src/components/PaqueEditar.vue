<template>
    <div class="contenedor">
        <div>
            <h3>Editar Paquetes</h3>
            <form class="formulario__registro" action="#">

                <label class="formulario__registro-inputs" for="codigo">Código</label>
                <input class="formulario__registro-inputs" required type="text" placeholder="Código" id="codigo">
                
                <label v-show="siEditar" class="formulario__registro-inputs" for="nombre_pac">Nombre del Paquete</label>
                <input v-show="siEditar" class="formulario__registro-inputs" required type="text" placeholder="Nombre del Paquete" id="nombre_pac" >

                <label v-show="siEditar" class="formulario__registro-inputs" for="ubicacion">Descripcion</label>
                <input v-show="siEditar" class="formulario__registro-inputs" required type="text" placeholder="Descripcion" id="descripcion" >

                <label v-show="siEditar" class="formulario__registro-inputs" for="precio">Precio</label>
                <input v-show="siEditar" class="formulario__registro-inputs" required type="text" placeholder="Precio" id="precio" >

                <label v-show="siEditar" class="formulario__registro-inputs" for="duracion">Duracion (dias)</label>
                <input v-show="siEditar" class="formulario__registro-inputs" required type="text" placeholder="Duración" id="duracion" >

                <label v-show="siEditar" class="formulario__registro-inputs" for="salida">Salida</label>
                <input v-show="siEditar" class="formulario__registro-inputs" required type="text" placeholder="Salida" id="salida" >


            </form>
            <div class="formulario-botones">  
                <button type="button" @click="limpiar">Limpiar</button>
                <button v-if="!codigo" type="button" @click="consultarCodigo">Código</button>
                <button v-if="codigo" type="button" @click="editarPaquete">Editar Paquete</button>

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
            codigo:false,
            siEditar:false,

        }


    },
    methods: {
        async consultarCodigo(){
            const consultarCodigo = document.getElementById('codigo').value;
            let respuesta = await api.getOne(`paquete/${consultarCodigo}`);
            
            if ( respuesta.data.codigo == consultarCodigo) {
                this.codigo = true;
                this.siEditar = true;
                document.getElementById('codigo').value = respuesta.data.codigo;
                
                document.getElementById('nombre_pac').value = respuesta.data.nombre_pac;
                document.getElementById('descripcion').value = respuesta.data.descripcion;
                document.getElementById('precio').value = respuesta.data.precio;
                document.getElementById('duracion').value = respuesta.data.duracion;
                document.getElementById('salida').value = respuesta.data.salida;
            } else {
                console.log("No hay resultado");
            }
            
        },
        async editarPaquete(){
            const _codigo = document.getElementById('codigo').value;
            const _nombre_pac = document.getElementById('nombre_pac').value;
            const _descripcion = document.getElementById('descripcion').value;
            const _precio = document.getElementById('precio').value;
            const _duracion = document.getElementById('duracion').value;
            const _salida = document.getElementById('salida').value;

            if ( _codigo != "" && _nombre_pac != "" && _descripcion != "" && _duracion != "" && _salida != ""  && _precio != "") {
                await api.edit(`paquete/${_codigo}`,{codigo:_codigo, nombre_pac:_nombre_pac, descripcion: _descripcion, precio: _precio, duracion:_duracion, salida:_salida});
                this.siEditar = false;
                this.actualiza();
                this.limpiar();
                alert("El paquete ha sido editado correctamente");
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
    width: 40%;
    margin: 0 auto;
}
.formulario__registro{
    display: grid;
    grid-template-columns: 1fr 1fr;
    background-color: rgb(213, 211, 208);
    padding: 10px;
    border-radius: 5px;
    margin-left: 20px;

}
.formulario__registro-inputs{
    padding: 2px;
    margin: 5px;
}
.formulario-botones{
    display: flex;
    justify-content: space-between;
    margin-top: 10px;
    margin-left: 20px;
}
</style>