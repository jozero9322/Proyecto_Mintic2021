<template>
  <div class="Login-form">
    <Navegacion />
    <!-- <HelloWorld msg="Welcome to Your Vue.js App" /> -->
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
      <input class="form-submit" type="submit" value="Login" />
    </form>
  </div>
</template>

<style scoped>
.form {
  width: 30%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
  border-radius: 5px;
  line-height: 20pt;
}
.form {
  background-color: rgba(0, 128, 0, 0.404);
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

<style></style>
