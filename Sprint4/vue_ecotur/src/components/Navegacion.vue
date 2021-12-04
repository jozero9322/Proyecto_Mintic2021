<template>
    <nav class="navegacion">
        <li>Inicio de Sesion</li>
        <li>Acerca de Nosotros</li>
    </nav>
</template>

<style scoped>
.navegacion{
    display: flex;
    justify-content:flex-end;
    list-style-type: none;
}
li{
    padding: 8px;
    margin-right: 2px;
    background-color: rgb(223, 133, 133);
}
</style>

<script>
export default {
    name:"Navegacion",
    data: function (){
        return {
            varibale1:1,
        }
    }
}
</script>


