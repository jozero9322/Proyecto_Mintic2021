<template>
<div id="h1">
      <h1>
        <img id="logo" src="@/assets/logo.png" alt="" >
        Ecoturismo en Colombia
      </h1>
      
      </div>

  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Rancho&effect=shadow-multiple">
  <div class="topnav" id="myTopnav">
    <router-link to="/">Home</router-link> 
    <div  class="dropdown">
    <button class="dropbtn">Operacion  <i class="fa fa-caret-down"></i> </button>
    <div class="dropdown-content">
      <router-link to="/reserva">Reserva</router-link>
      <router-link to="/paquete">Paquete</router-link>
       <router-link to="/cliente">Cliente</router-link>
      
    </div>
  </div> 
     
    <router-link to="/about">About</router-link>
    <router-link to="/login">Log in</router-link>
    <a v-if="id" @click.prevent="cerrarSesion" href="#">Log out</a>
    <h3 v-if="id">user: {{un}}</h3>

    
    <a href="javascript:void(0);" style="font-size:15px;" class="icon" onclick="myFunction()">&#9776;</a>
  
  </div>
  <router-view/>
</template>

<script>
export default{
  mounted(){
    this.id=localStorage.cliente
    this.un=localStorage.usuario
   
  },
  data(){
    return{
      id:-1,
      un:""
    }
  },
  methods:{
    cerrarSesion(){
      localStorage.clear();
      //this.$router.go(0);
    }
  }
}

function myFunction() {
  var x = document.getElementById("myTopnav");
  if (x.className === "topnav") {
    x.className += " responsive";
  } else {
    x.className = "topnav";
  }
}
</script>

<style>
#app {
  font-family: 'Rancho', sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color:darkgreen;
  background-color: #f1efe1 ;
  
}

h1{
  text-align:center;font-family: 'Rancho', serif;
	color: #192954;
    font-size: 30px;
    text-shadow: 4px 4px 4px #aaa;
}
h3{
  color: whitesmoke;
  font-family:'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
  font-weight: normal;
  font-size: 14px;;
}

#logo {

  width:7rem;
  height:5rem;

}
#nav {
  padding: 30px;
  background-color: #192954 ;
  overflow: hidden;
  
}

#nav a {
   float:left;
   color: white;
    font-size: 18px;
    text-decoration: none;
    padding: 1rem 2rem;
    height: 1rem;
	text-align:center;font-family: 'Rancho', serif;
}


#nav a.router-link-exact-active {
  
  color: chocolate;
  
}




.bg-img {
 
  background-color: white;
  min-height: 380px;

  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
  position: relative;
  text-align:left;font-family: 'Rancho', serif;
  background: rgb(0, 0, 0); /* Fallback color */
  background: rgba(0, 0, 0, 0.5); /* Black background with 0.5 opacity */
  color: #f1f1f1;
  
  padding: 20px;
}

.btn {

    background: rgb(0, 0, 0); /* Fallback color */
  background: rgba(0, 0, 0, 0.1); /* Black background with 0.5 opacity */
  border-radius: 5px;
  border: none; /* Remove borders */
  color: darkgreen;
  padding: 12px 16px; /* Some padding */
  font-size: 16px; /* Set a font size */
  cursor: pointer; /* Mouse pointer on hover */
}

.button_sesion {border-radius: 25px;}


.topnav {
  overflow: hidden;
  background-color: #192954;
}

.topnav a {
  float: left;
  display: block;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}



.topnav .icon {
  display: none;
}

.dropdown {
  float: left;
  overflow: hidden;
}

.dropdown .dropbtn {
  font-size: 17px;    
  border: none;
  outline: none;
  color: white;
  padding: 14px 16px;
  background-color: inherit;
  font-family: inherit;
  margin: 0;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f1efe1 ;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content a {
  float: none;
  color: #192954;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
  text-align: left;
}

.topnav a:hover, .dropdown:hover .dropbtn {
  background-color: #555;
  color: white;
}

.dropdown-content a:hover {
  background-color: #ddd;
  color: black;
}

.dropdown:hover .dropdown-content {
  display: block;
}

@media screen and (max-width: 600px) {
  .topnav a:not(:first-child), .dropdown .dropbtn {
    display: none;
  }
  .topnav a.icon {
    float: right;
    display: block;
  }
}

@media screen and (max-width: 600px) {
  .topnav.responsive {position: relative;}
  .topnav.responsive .icon {
    position: absolute;
    right: 0;
    top: 0;
  }
  .topnav.responsive a {
    float: none;
    display: block;
    text-align: left;
  }
  .topnav.responsive .dropdown {float: none;}
  .topnav.responsive .dropdown-content {position: relative;}
  .topnav.responsive .dropdown .dropbtn {
    display: block;
    width: 100%;
    text-align: left;
  }
}
</style>
