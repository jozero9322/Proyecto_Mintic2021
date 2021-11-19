<template>

<main>
  <div id="lateral"> 
    <h3>Regiones</h3>
    <ul >

    <li><router-link class="ex1" to="/costa">Costa Atlantica</router-link></li>
		<li><router-link class="ex1" to="/boyaca">Boyaca</router-link></li>
		<li><router-link class="ex1" to="/caldas">Caldas</router-link></li>
    <li><router-link class="ex1" to="/cundinamarca">Cundinamarca</router-link></li>
	  <li><router-link class="ex1" to="/santander">Santander</router-link></li>
	
		
		</ul>

    </div>
 <div class="contenido">
   <div>
                       
                
                
                
                <img  id="img" src="@/assets/sierra_nevada.jpg" alt="">
				<img  id="img" src="@/assets/sierra_nevada1.jpg" alt="">
				<img id="img" src="@/assets/cascada-matuna.jpg" alt="">
				<img id="img" src="@/assets/Zarza3.jpg" alt="">
			</div>
                    

<div>
  
  <h2 class="font-effect-shadow-multiple">¿En dónde practicar ecoturismo en Colombia??</h2>
  Colombia es el destino ideal para todos aquellos viajeros que busquen explorar y conocer de cerca las maravillas naturales del mundo. Aunque existen muchos sitios en el país donde puedes practicar el ecoturismo, estos son los más visitados:
  <div>
<li>Parque Nacional Natural Los Nevados</li>
<li>Isla Gorgona</li>
<li>Amazonas</li>
<li>Alta Guajira</li>
<li>Ensenada de Utría</li>
<li>Parque Nacional Natural Puracé</li>
<li>Parque Nacional Natural Tayrona</li>
<li>Santuario de Fauna y Flora Iguaque</li>
<li>Parque Nacional Natural Cueva de los Guácharos</li>
<li>Parque Nacional Natural Corales del Rosario y de San Bernardo</li>
</div> 
</div>
               </div>
			

</main>
</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'

export default {
  name: 'Home',
  
  components: {
    
  }
}
</script>

<style  scoped>
   body{
            padding: 2rem;
			
        }
      

        main{
            display: grid;
            grid-template-columns: 1fr 2fr ;
			      background-image: url("../assets/fondo.jpg");
              align-content: left;
			
        }
        #lateral{
          background-color: rgb(255, 255, 255);
          min-height: 280px;

          /* Center and scale the image nicely */
          background-position: center;
          background-repeat: no-repeat;
          background-size: cover;
          position: relative;
          text-align:left;font-family: 'Rancho', serif;
          background: rgb(0, 0, 0); /* Fallback color */
          background: rgba(0, 0, 0, 0.5); /* Black background with 0.5 opacity */
          color: #f1f1f1;
          font-size: 18px;;
          padding: 20px;
        }

        a.ex1:link{color:lightgray;text-decoration:none;font-family: 'Rancho', serif; }
        a.ex1:visited{color:white;text-decoration:none;font-family: 'Rancho', serif; }
        a.ex1:hover {text-decoration:underline;}

.contenido {
    padding: 2rem;
    text-align: left;
    display: grid;

    grid-template-columns: 1fr 3fr ;
	font-family: Arial;
  font-size: 17px;
  font-family: 'Rancho', serif;
}

#img {

  width:9rem;
  height:7rem;

}
</style>
