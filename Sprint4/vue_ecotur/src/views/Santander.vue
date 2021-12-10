<template>
  <main>
    <NavPaquetes/>
    <section>
      <h1>Ecoturismo en Colombia</h1>
      <h2>ECOTURISMO EN SANTANDER</h2>
      <div>
        <h2>¿Qué actividades se pueden desarrollar en Santander?</h2>

        <img id="img" src="@/assets/barichara.jpg" alt="imagen" />
        <div>
          Santander te ofrece la oportunidad de conectarte con la naturaleza de una
          manera magica, puedes conocer su capital Bucaramanga y los municipios 
          emblemanticos como San Gil, Braichara, Barrancabermenja.
        </div>
      </div>
    </section>
   
  </main>
</template>

<script>
import NavPaquetes from "@/components/NavPaquetes"
export default {
  name:"Santander",
  components:{
    NavPaquetes,
  }
  
}
</script>


<style  scoped>
body {
  padding: 2rem;

}
h1{
  text-shadow: 0 0 3px #FF0000, 0 0 5px #0000FF;
  font-size: 45px;
}
h2{
    color: blue;
    
}
h3{
    color: rgb(46, 236, 46);
    font-family: Verdana, Geneva, Tahoma, sans-serif;
}

#img {
  width: 15rem;
  height: 12rem;
}
</style>