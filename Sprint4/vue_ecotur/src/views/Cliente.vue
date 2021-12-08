<template>
<div>
  <h1>Ecoturismo en Colombia</h1>

    <div class="row">
      
      <div class="registro">

        <h1>Registrar Clientes</h1><br><br><br>

        <form @submit.prevent="AgregarCliente">
          <div>
            <label for="Documento">Documento: </label>
            <input type="text" name="Documento" id="documento">
          </div>
          <div>

            <label for="Nombre">Nombre: </label>
            <input type="text" name="Nombre" id="Nombre">
          </div>
          <div>
            <label for="Usuario">Usuario: </label>
            <input type="text" name="Usuario" id="Usuario">
          </div>
          <div>
            <label for="password">password: </label>
            <input type="password" name="password" id="password">
          </div>
          <button type="button">Agregar Cliente</button>
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
  display: flex;
  flex-direction: column;
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