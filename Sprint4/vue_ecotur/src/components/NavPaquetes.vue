<template>
  <nav class="navegacion">
    
    <li><router-link to="/listado-paquetes">Volver</router-link></li>

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
  name: "NavPaquetes",
  data: function () {
    return {

    };
  },
};
</script>
