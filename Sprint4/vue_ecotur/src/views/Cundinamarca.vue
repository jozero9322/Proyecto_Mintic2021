<template>
  <main>
    <NavPaquetes/>
    <br />
    <section>
      <h1>Ecoturismo en Colombia</h1>
      <h2>ECOTURISMO EN CUNDINAMARCA</h2>
      <div>
        <h2>¿Qué actividades se pueden desarrollar en Cundinamarca?</h2>
        <br />

        <img id="img" src="@/assets/Instalaciones.jpg" alt="" />
        <div>
          Si quieres conectarte con la naturaleza, pero no quieres desplazarte
          en largas distancias, los ecoparques cerca de Bogotá son una excelente
          opcion. Podrás salir de la monotonía, hacer senderismo, deportes
          extremos y disfrutar de los hermosos paisajes que ofrece Cundinamarca
          y sus municipios.
        </div>
      </div>
    </section>
    <section>
      <h2>Parque Natural Chicaque</h2>
      <br />
      <div>
        Este lugar se encuentra ubicado al sur occidente de la Sábana de Bogotá.
        Está en el municipio de San Antonio de Tequendama, a tan solo 30 minutos
        de la capital. Puedes llegar en carro por la vía La Mesa o por Soacha.
        Es un bosque de niebla en el que puedes hacer senderismo, cabalgar,
        acampar en casas en los árboles y mucho más. Además, si lo que quieres
        es pasar más tiempo allí puedes hacerte voluntario y trabajar en las
        huertas, las investigaciones, el apoyo de control contra la erosión y
        mucho más.
      </div>

      <img id="img" src="@/assets/Avistamiento.jpg" alt="" />
      <br />
    </section>
    <section>
      <h2>Bioparque La Reserva</h2>
      <br />
      <div>
        Este parque es un santuario de plantas y animales rescatados del tráfico
        ilegal. Cuenta con guías que te ayudarán con un recorrido por varios
        ecosistemas colombianos. De acuerdo con su página web, han rescatado y
        liberado a 184 animales, se han restaurado 5 hectáreas de bosque y se
        han sensibilizado a 464.000 personas.
      </div>
      <img id="img" src="@/assets/Cultivos.jpg" alt="" />

      <br />
      <h2>Ecoparque Chinauta</h2>
      <div>
        A 70 kilómetros de Bogotá, en el municipio de Fusagasugá, se encuentra
        este lugar. Inicialmente, en 1999, era un restaurante y en 2004 se
        incorporaron programas pedagógicos, recreativos y empresariales. Puedes
        recorrer las instalaciones, hacer camping, glamping y conocer más de los
        paisajes, la flora y la fauna que allí se alberga.
      </div>

      <img id="img" src="@/assets/Camping.jpg" alt="" />
    </section>
  </main>
</template>

<style scoped>
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
  width: 20rem;
  height: 15rem;
}
</style>

<script>
// @ is an alias to /src

import NavPaquetes from "@/components/NavPaquetes";

export default {
  name: "Cundinamarca",
  components: {
    NavPaquetes,
  },
  methods: {},
  data: function () {
    return {};
  },
};
</script>
