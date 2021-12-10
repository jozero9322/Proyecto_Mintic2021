<template>
  <div >
    <NavHome/>
    <h1>Bienvenido al Ecoturismo en Colombia</h1>
    <img src="@/assets/barichara.jpg" alt="barichara">
  </div>
</template>

<script>
// @ is an alias to /src
import NavHome from "@/components/NavHome"
export default {
  name: "Home",
  components: {
    NavHome,
  },
};
</script>

<style scoped>


h1{
  text-shadow: 0 0 3px #FF0000, 0 0 5px #0000FF;
  font-size: 45px;
}
  
</style>