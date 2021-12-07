<template>
<div>
  <h1>Ecoturismo en Colombia</h1>
  <div class="row">
    
    <div class="registro">

      <h1>Registrar Clientes</h1><br><br><br>

      <form @submit.prevent="AgregarCliente">
        <label for="Documento">Documento: </label>
        <input type="text" name="Documento" id="documento"><br><br>
        <label for="Nombre">Nombre: </label>
        <input type="text" name="Nombre" id="Nombre"><br><br>
        <label for="Usuario">Usuario: </label>
        <input type="text" name="Usuario" id="Usuario"><br><br>
        <label for="password">password: </label>
        <input type="password" name="password" id="password"><br><br>
        <button type="submit">Agregar Cliente</button>
      </form>
    </div>
    <div class="liscli">
      <h2>Lista Clientes</h2>
      <table>
        <thead>
          <tr>
            <th>Documento</th>
            <th>Nombre</th>
            <th>Usuario</th>
            <th>Password</th>
            <th>Editar</th>
            <th>Eliminar</th>
          </tr>
        </thead>
      </table>
    </div>
    
  </div>

</div>

  
</template>

<script>
// @ is an alias to /src


export default {
  name: "Cliente",
  components: {
   
  },
};
</script>
<style scoped>
.row{
  display: flex;
  
}
.registro{
  background: greenyellow;
  width: 30%;
  height: auto;
  padding: 20px;
}
.liscli{
  background: darkcyan;
  width: 70%;
}
th{
  border:solid black 1px;
  color: black;
}
table{
  background: salmon;
  margin-left: 30em;
}

</style>