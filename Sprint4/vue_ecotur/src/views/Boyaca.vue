<template>
  <div>
    <NavPaquetes/>

    <h1>Ecoturismo En Colombia</h1>

    <h2>ECOTURISMO EN BOYACA</h2>
    <P>Boyacá es uno de los 32 departamentos de Colombia, está situado en el Centro de Este del país, bajo la cordillera oriental de los Andes. Es un departamento rico en flora y fauna, que cuenta con diferentes tipos de paisajes para todo tipo de gusto.<br> A continuación, relacionamos uno de ellos. </P>
    <h3>Sendero de la Zarsa</h3>
    <img src="https://descubreboyaca.com/wp-content/uploads/2019/12/sendero-la-zarza-duitama-e1576800614511.jpg" alt="Sendero de la Zarsa">
    <p class="fre">Este sendero se ubica en el municipio de fui tema vete a la Trinidad, el cual se encuentra a unos 15 minutos de Duitama en bus. Es un sendero qué parte en un ecosistema de bosque andino bordeado de una quebrada de un pequeño río, pasando por una Alta cascada rocosa punto para finalizar en un ecosistema de Páramo antes del 1963 jue paso obligatorio de la comunicación entre los habitantes del departamento de Santander con la región de Tundama en Boyacá y los Llanos orientales juntos un camino de herradura que contempla la energía de nuestros indígenas.</p>
    <h3>Paramo y Laguna de Siscunsi</h3>
    <img src="https://situr.boyaca.gov.co/wp-content/uploads/2017/07/SOGA..-LAGUNA.png" alt="Paramo y Laguna de Siscunsi">
    <p>Las 5942 hectáreas de Páramo de Sogamoso se encuentran en la vereda de las cintas , las cañas y el mortiñal. </p>
  </div>
</template>

<script>
// @ is an alias to /src
import NavPaquetes from "@/components/NavPaquetes"

export default {
  name: "Boyaca",
  components: {
    NavPaquetes,
   
  },
};
</script>
<style scoped>
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