<template>
   <div>
         <NavPaquetes/>
    <h1>Ecoturismo En Colombia</h1>

    <h2>ECOTURISMO EN CALDAS</h2>
    <P>La Catedral Basílica Metropolitana Nuestra Señora del Rosario de Manizales es un templo católico, emplazado frente a la Plaza de Bolívar, en la ciudad de Manizales, Colombia. </P>
    <h3>Catedral DE Manizales</h3>
    <img src="https://cloudfront-us-east-1.images.arcpublishing.com/semana/LYOCL7KIGJFHVNRDTFDK7X673Y.jpg" alt="Catedral de manizalez">
    
  </div>
</template>

<script>
// @ is an alias to /src
import NavPaquetes from "@/components/NavPaquetes"

export default {
  name: "Caldas",
  components: {
    NavPaquetes,
  },
};
</script>
<style scoped>
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
p{
    text-align: center justify;
}
img{
  width: 50rem;
  height: 30em;
}
</style>