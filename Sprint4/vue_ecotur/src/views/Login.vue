<template>
  <div >
    
    <Navegacion/>
    <!-- <HelloWorld msg="Welcome to Your Vue.js App" /> -->
  </div>
</template>

<script>
// @ is an alias to /src

import Navegacion from "@/components/Navegacion"


export default {
  name: "Login",
  components: {
   Navegacion,
  },
  methods:{

  },
  data: function(){
      return {

      }
  }
};
</script>