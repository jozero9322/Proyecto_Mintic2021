<template>
  <div >
    
    <Navegacion/>
    <Paque/>
     
  </div>
</template>

<script>
// @ is an alias to /src

import Navegacion from "@/components/Navegacion"
import Paque from "@/components/Paque"


export default {
  name: "Paquetes",
  components: {
   Navegacion,
   Paque,
  },
};
</script>