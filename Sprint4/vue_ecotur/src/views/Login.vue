<template>
  <div class="Login-form">
    <Navegacion />

    <h1>Inicio de Sesion</h1>
    <form action class="form">
      <label class="form-label" for="#Usuario">Usuario:</label>
      <input
        class="form-input"
        type="Usuario"
        id="Usuario"
        required
        placeholder="Usuario"
      />
      <label class="form-label" for="#Contraseña">Contraseña:</label>
      <input
        class="form-input"
        type="Contraseña"
        id="Contraseña"
        placeholder="Contraseña"
      />
      <button>ingresar</button>
      <p class="message">
        No esta registrado? <a href="#">Crear una cuenta</a>
      </p>
    </form>
  </div>
</template>

<style scoped>
.form {
  position: relative;
  z-index: 1;
  background: #ffffff;
  max-width: 360px;
  margin: 0 auto 100px;
  padding: 45px;
  text-align: center;
  box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
}
.form input {
  font-family: "Arial", sans-serif;
  outline: 0;
  background: #f2f2f2;
  width: 100%;
  border: 0;
  margin: 0 0 15px;
  padding: 15px;
  box-sizing: border-box;
  font-size: 14px;
}
.form button {
  font-family: "Arial", sans-serif;
  text-transform: uppercase;
  outline: 0;
  width: 100%;
  border: 0;
  padding: 15px;
  color: #ffffff;
  font-size: 14px;
  -webkit-transition: all 0.3 ease;
  transition: all 0.3 ease;
  cursor: pointer;
  background: #4caf50;
}

.Login-form {
  background-image: url("../assets/Fondo.jpg");
  size-adjust: flex;
}
</style>

<script>
// @ is an alias to /src

import Navegacion from "@/components/Navegacion";

export default {
  name: "Login",
  components: {
    Navegacion,
  },
  methods: {},
  data: function () {
    return {};
  },
};
</script>
