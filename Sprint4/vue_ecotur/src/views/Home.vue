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
