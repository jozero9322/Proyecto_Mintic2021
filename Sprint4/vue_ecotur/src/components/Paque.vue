<template>
<div>
    <h1>Gestion de Paquetes</h1>
    <div class="contenedor">
        <div>
            <h3>Registrar Paquetes</h3>
            <form class="formulario__registro" action="#">
                <label class="formulario__registro-inputs" for="Descripcion">Descripcion del Paquete</label>
                <input class="formulario__registro-inputs" type="text" placeholder="Descripcion" id="Descripcion">
                <label class="formulario__registro-inputs" for="Ubicacion">Ubicación</label>
                <input class="formulario__registro-inputs" type="text" placeholder="Ubicación" id="Ubicacion">
                <label class="formulario__registro-inputs" for="Duracion">Duracion (dias)</label>
                <input class="formulario__registro-inputs" type="text" placeholder="Duración" id="Duracion">
                <label class="formulario__registro-inputs" for="Salida">Salida</label>
                <input class="formulario__registro-inputs" type="text" placeholder="Salida" id="Salida">
                <label class="formulario__registro-inputs" for="Precio">Precio</label>
                <input class="formulario__registro-inputs" type="text" placeholder="Precio" id="Precio">
            </form>
            <div class="formulario-botones">
                <button>Limpiar</button>
                <button>Agregar Paquete</button>
            </div>
        </div>
        <div>
            <h3>Listado de Paquetes</h3>
        </div>
    </div>
</div>
</template>

<script>
export default {
    name:"Paquetes"

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