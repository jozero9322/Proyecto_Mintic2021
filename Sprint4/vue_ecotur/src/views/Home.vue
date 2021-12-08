<template>
  <div >
    <Navegacion/>
    <h1>Bienvenido al Ecoturismo en Colombia</h1>
    <img src="@/assets/barichara.jpg" alt="barichara">
  </div>
</template>

<script>
// @ is an alias to /src
import Navegacion from "@/components/Navegacion"
export default {
  name: "Home",
  components: {
    Navegacion,
  },
};
</script>
