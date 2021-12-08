<template>
  <div class="contenedor">
      <div class="info">
          <span>{{texto}}</span>
      </div>
      
  </div>
</template>

<script>
export default {
    name:"Alert",
    props:{
        texto: String,
    
    }

}
</script>

<style scoped>
.contenedor {
    display: flex;
    width: 90vw;
    height: 100vh;
    z-index: 1;
    position: fixed;
    background-color: red;
    justify-content: center;
    align-items: center;
}
.info {
    display: flex;
    width: 300px;
    height: 300px;

}
</style>