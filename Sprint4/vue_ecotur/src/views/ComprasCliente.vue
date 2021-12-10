<template>
  <div >

    <NavPaquetes/>
    <h1>Compras Cliente</h1>
    <ReserCrear/>
   
  </div>
</template>

<script>
// @ is an alias to /src

import NavPaquetes from "@/components/NavPaquetes"
import ReserCrear from "@/components/ReserCrear"

export default {
  name: "ComprasCliente",
  components: {

    NavPaquetes,
    ReserCrear,
  },
};
</script>
