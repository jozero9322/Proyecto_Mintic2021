<template>
  <nav class="navegacion">
    
    <li><router-link to="/login">Inicio de Sesión</router-link></li>
    <li><router-link to="/paquetes">Paquetes</router-link></li>
    <li><router-link to="/reservas">Reservas</router-link></li>
    <li><router-link to="/clientes">Clientes</router-link></li>
    <li><router-link to="/index">Cerrar Sesión</router-link></li>
  </nav>
</template>

<style scoped>
.navegacion {
  display: flex;
  justify-content: flex-end;
  list-style-type: none;
}
li {
  padding: 8px;
  margin-right: 2px;
  background-color: rgb(223, 133, 133);
}
</style>

<script>
export default {
  name: "Navegacion",
  data: function () {
    return {
      varibale1: 1,
    };
  },
};
</script>
