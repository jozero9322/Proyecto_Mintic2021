<template>
  <div>
    <PaqueVer/>

    <div class="contenedor">
        <label class="labels" for="">Vista el detalle del paquete en Santander</label>
        <router-link class="labels" to="/santander">Santander</router-link>

        <label class="labels" for="">Vista el detalle del paquete en Cundinamarca</label>
        <router-link class="labels" to="/cundinamarca">Cundinamarca</router-link>

        <label class="labels" for="">Vista el detalle del paquete en Costa</label>
        <router-link class="labels" to="/costa">Costa</router-link>

        <label  class="labels" for="">Vista el detalle del paquete en Boyaca</label>
        <router-link  class="labels" to="/boyaca">Boyaca</router-link>

        <label class="labels" for="">Vista el detalle del paquete en Caldas</label>
        <router-link class="labels" to="/caldas">Caldas</router-link>
    </div>

    <div >
      <router-link class="comprar" to="/compras_cliente">Ir a comprar</router-link>
      <label class="comprar" for=""></label>
    </div>
  </div>
</template>

<script>
import PaqueVer from "@/components/PaqueVer"
export default {
  name:"ListadoPaquetes",
  components:{
    PaqueVer,
  }
}
</script>

<style scoped>
.contenedor {
  display: grid;
  grid-template-columns: 2fr 1fr;
  width: 50%;
  margin: 0 auto;
  margin-top: 40px;

}
.labels {
   padding: 10px;
}
.comprar {
  width:400px;
  height: 500px;
  background-color: red;
  font-size: 20px;

}
</style>


