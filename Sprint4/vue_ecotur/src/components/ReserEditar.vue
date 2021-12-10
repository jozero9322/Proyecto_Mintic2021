<template>
    <div class="contenedor">
        <div>
            <h3>Editar Reservas</h3>

            <form class="formulario__registro" action="#">

                <label class="formulario__registro-inputs" for="id_reserva">Id Reserva</label>
                <input class="formulario__registro-inputs" required type="text" placeholder="ID Reserva" id="id_reserva">

                <label v-show="siEditar" class="formulario__registro-inputs" for="cliente_cedula">Cedula Cliente</label>
                <input v-show="siEditar" class="formulario__registro-inputs" required type="text" placeholder="Cedula del Cliente" id="cliente_cedula">

                <label v-show="siEditar" class="formulario__registro-inputs" for="paquete_codigo">Codigo Paquete</label>
                <input v-show="siEditar" class="formulario__registro-inputs" required type="text" placeholder="Codigo el Paquete" id="paquete_codigo">

                <label v-show="siEditar" class="formulario__registro-inputs" for="personas">Personas Adultas</label>
                <input v-show="siEditar" class="formulario__registro-inputs" required type="text" placeholder="Adultos" id="personas">

                <label v-show="siEditar" class="formulario__registro-inputs" for="ninos">Niños</label>
                <input v-show="siEditar" class="formulario__registro-inputs" required type="text" placeholder="Niños" id="ninos">

                <label v-show="siEditar" class="formulario__registro-inputs" for="total">Total ($)</label>
                <input v-show="siEditar" class="formulario__registro-inputs" required type="text" placeholder="Total" id="total">



            </form>


            <div class="formulario-botones">  
                <button type="button" @click="limpiar">Limpiar</button>
                <button v-if="!codigo" type="button" @click="consultarReserva">Id Reserva</button>
                <button v-if="codigo" type="button" @click="editarReserva">Editar Reserva</button>

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
            codigo:false,
            siEditar:false,

        }


    },
    methods: {
        async consultarReserva(){
            const consultarCodigo = document.getElementById('id_reserva').value;

            let respuesta = await api.getOne(`reserva/${consultarCodigo}`, {token: auth.getToken()} );
            console.log(respuesta);
            
            if ( respuesta.data.id_reserva == consultarCodigo) {
                this.codigo = true;
                this.siEditar = true;
                document.getElementById('id_reserva').value = respuesta.data.id_reserva;
                document.getElementById('personas').value = respuesta.data.personas;
                document.getElementById('ninos').value = respuesta.data.ninos;
                document.getElementById('total').value = respuesta.data.total;
                document.getElementById('cliente_cedula').value = respuesta.data.cliente_cedula;
                document.getElementById('paquete_codigo').value = respuesta.data.paquete_codigo;
            } else {
                console.log("No hay resultado");
            }
            
        },
        async editarReserva(){
            const _id_reserva = document.getElementById('id_reserva').value;
            const _personas = document.getElementById('personas').value;
            const _ninos = document.getElementById('ninos').value;
            const _total = document.getElementById('total').value;
            const _cliente_cedula = document.getElementById('cliente_cedula').value;
            const _paquete_codigo = document.getElementById('paquete_codigo').value;

            if ( _id_reserva != "" && _personas != "" && _ninos != "" && _total != "" && _cliente_cedula != ""  && _paquete_codigo != "") {
                await api.edit(`reserva/${_id_reserva}`,{id_reserva:_id_reserva, personas:_personas, ninos: _ninos, total: _total, cliente_cedula:_cliente_cedula, paquete_codigo:_paquete_codigo, token: auth.getToken()});
                this.siEditar = false;
                this.actualiza();
                this.limpiar();
                alert("La reserva se edito exitosamente");
            } else {
                alert('Ingrese todos los datos');
            }         
        },
        limpiar(){
            document.getElementById('id_reserva').value = "";
            document.getElementById('personas').value = "";
            document.getElementById('ninos').value = "";
            document.getElementById('total').value = "";
            document.getElementById('cliente_cedula').value = "";
            document.getElementById('paquete_codigo').value = "";
            this.siEditar = false;
            this.codigo = false;
        },
        async actualiza(){
            const resp = await api.getAll("reservas");
            this.allReservations = resp.data;
    }

    },
    async mounted(){

        const resp = await api.getAll("reservas");
        this.allReservations = resp.data;
    },

}

</script>



<style scoped>
.contenedor{
    width: 40%;
    margin: 0 auto;
}
.formulario__registro{
    display: grid;
    grid-template-columns: 1fr 1fr;
    background-color: rgb(213, 211, 208);
    padding: 10px;
    border-radius: 5px;
    margin-left: 20px;

}
.formulario__registro-inputs{
    padding: 2px;
    margin: 5px;
}
.formulario-botones{
    display: flex;
    justify-content: space-between;
    margin-top: 10px;
    margin-left: 20px;
}
</style>