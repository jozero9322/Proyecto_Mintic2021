<template>
  <div >
    <NavHome/>
    <h1>Compras Cliente</h1>
    <ReserCrear/>
   
  </div>
</template>

<script>
// @ is an alias to /src
import NavHome from "@/components/NavHome"
import ReserCrear from "@/components/ReserCrear"

export default {
  name: "ComprasCliente",
  components: {
    NavHome,
    ReserCrear,
  },
};
</script>
