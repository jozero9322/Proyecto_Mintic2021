<template>
<div>

    <div class="contenedor">
        <div>
            <h3>Crear Reservas</h3>
            <form class="formulario__registro" action="#">

                <label class="formulario__registro-inputs" for="id_reserva">Id Reserva</label>
                <input class="formulario__registro-inputs" required type="text"  disabled="true" id="id_reserva">

                <label class="formulario__registro-inputs" for="cliente_cedula">Cedula Cliente</label>
                <input class="formulario__registro-inputs" required type="text" placeholder="Cedula del Cliente" id="cliente_cedula">

                <label class="formulario__registro-inputs" for="paquete_codigo">Codigo Paquete</label>
                <input class="formulario__registro-inputs" required type="text" placeholder="Codigo el Paquete" id="paquete_codigo">
                <label class="formulario__registro-inputs" for="personas">Personas Adultas</label>
                <input class="formulario__registro-inputs" required type="text" placeholder="Adultos" id="personas">

                <label class="formulario__registro-inputs" for="ninos">Niños</label>
                <input class="formulario__registro-inputs" required type="text" placeholder="Niños" id="ninos">

                <label class="formulario__registro-inputs" for="total">Total ($)</label>
                <input class="formulario__registro-inputs" required type="text" placeholder="Total" id="total">




            </form>
            <div class="formulario-botones">  
                <button type="button" @click="limpiar">Limpiar</button>
                <button type="button" @click="agregarReserva">Crear reserva</button>

            </div>
        </div>
        <div class="contenedor__listado">
            <h3>Listado de Paquetes</h3>
            
            <table border="1">
              <thead>
                    <tr>
                        <th>Código</th>
                        <th>Nombre</th>
                        <th>Descripción</th>
                        <th>Predio</th>
                        <th>Duración</th>
                        <th>Salida</th>
                    </tr>
                </thead>

                <tbody >
                    <tr v-for="eachPackage in allPackages" :key="eachPackage">
                        <td>{{eachPackage.codigo}}</td>
                        <td>{{eachPackage.nombre_pac}}</td>
                        <td>{{eachPackage.descripcion}}</td>
                        <td>{{eachPackage.precio}}</td>
                        <td>{{eachPackage.duracion}}</td>
                        <td>{{eachPackage.salida}}</td>
                        
                    </tr>        
                </tbody>

            </table>

        </div>
    </div>
</div>
</template>


<script>
import api from "@/logic/api.js";
import auth from "@/logic/autenticacion.js"

export default {
    name:"Paquetes",
    data: function(){
        return {
            allReservations: [],
            allPackages: [],
        }


    },
    methods: {

        async agregarReserva(){
            
            const _idReserva = document.getElementById('id_reserva').value;
            const _personas = document.getElementById('personas').value;
            const _ninos = document.getElementById('ninos').value;
            const _total = document.getElementById('total').value;
            const _clienteCedula = document.getElementById('cliente_cedula').value;
            const _paqueteCodigo = document.getElementById('paquete_codigo').value;

            if ( _idReserva != "" && _personas != "" && _ninos != "" && _total != "" && _clienteCedula != ""  && _paqueteCodigo != "") {
                await api.create("reserva",{id_reserva:_idReserva, personas:_personas, ninos: _ninos, total: _total, cliente_cedula:_clienteCedula, paquete_codigo:_paqueteCodigo, token: auth.getToken()});
                alert("Su reserva ha sido hecha con éxito");
                this.actualiza();
                this.limpiar();
                this.$router.push({path:'listado-paquetes'});
            } else {
                alert('Ingrese todos los datos');
            }         
        },
        limpiar(){
            //document.getElementById('id_reserva').value = "";
            document.getElementById('personas').value = "";
            document.getElementById('ninos').value = "";
            document.getElementById('total').value = "";
            document.getElementById('cliente_cedula').value = "";
            document.getElementById('paquete_codigo').value = "";
        },
        async actualiza(){
            const resp = await api.getAll("reservas");
            this.allReservations = resp.data;
    }

    },
    async mounted(){

        const resp = await api.getAll("reservas", {token: auth.getToken()});
        this.allReservations = resp.data;
        document.getElementById('id_reserva').value = (this.allReservations.length) + 1;
        const resp2 = await api.getAll("paquetes", {token: auth.getToken()});
        this.allPackages = resp2.data;
        
    },

}

</script>



<style scoped>
.contenedor{
    display: grid;
    grid-template-columns: 1fr 1.5fr;
}
.formulario__registro{
    display: grid;
    grid-template-columns: 1fr 1fr;
    background-color: rgb(213, 211, 208);
    padding: 10px;
    border-radius: 5px;
    margin-left: 40px;

}
.formulario__registro-inputs{
    padding: 2px;
    margin: 5px;
}
.formulario-botones{
    display: flex;
    justify-content: space-between;
    margin-top: 10px;
    margin-left: 40px;
}
.contenedor__listado {
    align-items: center;
    margin: 0 auto;
}
</style>