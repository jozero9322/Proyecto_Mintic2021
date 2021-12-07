<template>
  <div>
    <div>
      <h1>Listado de Paquetes</h1>
      <table border="1">
        <thead>
          <tr>
            <th>Nombre</th>
            <th>Ubicacion</th>
            <th>Precio</th>
            <th>Duracion</th>
            <th>Salida</th>
          </tr>
        </thead>
        <tbody id="datos_paquete">
          <tr v-for="unPaquete in listaPaquetes" :key="unPaquete">
            <td>{{ unPaquete.nombre }}</td>
            <td>{{ unPaquete.ubicacion }}</td>
            <td>{{ unPaquete.precio }}</td>
            <td>{{ unPaquete.duracion }}</td>
            <td>{{ unPaquete.salida }}</td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<style scoped>
table {
  table-layout: fixed;
  width: 100%;
  border-collapse: collapse;
  border: 3px solid rgb(0, 136, 30);
}

thead th:nth-child(1) {
  width: 30%;
}

thead th:nth-child(2) {
  width: 20%;
}

thead th:nth-child(3) {
  width: 15%;
}

thead th:nth-child(4) {
  width: 35%;
}

th,
td {
  padding: 20px;
}
</style>

<script></script>
