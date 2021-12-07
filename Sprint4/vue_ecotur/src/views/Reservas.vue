<template>
<div>
    <Navegacion/>
    <h1>Gestion de Reservas</h1>

    <div class="contenedor">
        <div>
            <h3>Registro de Reservas</h3>
            <form class="formulario__reserva" action="#">

                <label for="paquete">Seleccione un Paquete</label>
                <select name="paquete" id="paquete">
                    <option v-for="eachPackage in allPackages" :key="eachPackage" :value="eachPackage">
                        {{eachPackage.nombre_pac}}
                    </option>
                </select>


            </form>
            <div class="formulario-botones">
                <button type="button" @click="crearPaquete">Crear Paquete</button>
                <button type="button" @click="limpiar">Limpiar</button>
            </div>
        </div>
        <div>
            <h3>Listado de Paquetes</h3>
        </div>
    </div>
</div>
</template>

<script>
import api from "@/logic/api.js";
import Navegacion from "@/components/Navegacion"

export default {
    data: function (){
        return{
            allPackages:[],
        }
    },
    components:{
        Navegacion,

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
    grid-template-columns: 1fr 2fr;
}
.formulario__registro{
    display: grid;
    grid-template-columns: 1fr 1fr;
    background-color: rgb(213, 211, 208);
    padding: 10px;
    border-radius: 5px;

}
.formulario__registro-inputs{
    padding: 2px;
    margin: 5px;
}
.formulario-botones{
    display: flex;
    justify-content: space-between;
    margin-top: 10px;
}
</style>