<template>
    <div class="contenedor">
        <div>
            <h3>Editar Clientes</h3>

            <form class="formulario__registro" action="#">

                <label class="formulario__registro-inputs" for="cedula">Cédula</label>
                <input class="formulario__registro-inputs" required type="text" placeholder="Cédula" id="cedula">

                <label v-show="siEditar" class="formulario__registro-inputs" for="nombre">Nombre</label>
                <input v-show="siEditar" class="formulario__registro-inputs" required type="text" placeholder="Nombre del Cliente" id="nombre">

                <label v-show="siEditar" class="formulario__registro-inputs" for="usuario">Usuario</label>
                <input v-show="siEditar" class="formulario__registro-inputs" required type="text" placeholder="Usuario" id="usuario">

                <label v-show="siEditar" class="formulario__registro-inputs" for="password">Password</label>
                <input v-show="siEditar" class="formulario__registro-inputs" required type="text" placeholder="Password" id="password">


            </form>
            <div class="formulario-botones">  
                <button type="button" @click="limpiar">Limpiar</button>
                <button v-if="!codigo" type="button" @click="consultarDatos">Datos</button>
                <button v-if="codigo" type="button" @click="editarCliente">Editar Cliente</button>

            </div>
        </div>
    </div>
</template>


<script>
import api from "@/logic/api.js";
import auth from "@/logic/autenticacion.js"

export default {
    name:"Clientes",
    data: function(){
        return {
            allClients: [],
            codigo:false,
            siEditar:false,

        }


    },
    methods: {
        async consultarDatos(){
            const consultarUsuario = document.getElementById('cedula').value;

            let respuesta = await api.getOne(`cliente/${consultarUsuario}`,{token: auth.getToken()});
            
            if ( respuesta.data.cedula == consultarUsuario) {
                this.codigo = true;
                this.siEditar = true;
                document.getElementById('cedula').value = respuesta.data.cedula;
                document.getElementById('nombre').value = respuesta.data.nombre;
                document.getElementById('usuario').value = respuesta.data.usuario;
                document.getElementById('password').value = respuesta.data.password;

            } else {
                console.log("No hay resultado");
            }
            
        },
        async editarCliente(){
            const _cedula = document.getElementById('cedula').value;
            const _nombre = document.getElementById('nombre').value;
            const _usuario = document.getElementById('usuario').value;
            const _password = document.getElementById('password').value;

            console.log(auth.getToken());

            if ( _cedula != "" && _nombre != "" && _usuario != "" && _password != "" ) {
                await api.edit(`cliente/${_cedula}`,{cedula:_cedula, nombre:_nombre, usuario: _usuario, password:_password, token: auth.getToken()});
                this.siEditar = false;
                this.actualiza();
                this.limpiar();
                alert("Los datos del cliente fueron editados");
            } else {
                alert('Ingrese todos los datos');
            }         
        },
        limpiar(){
            document.getElementById('cedula').value = "";
            document.getElementById('nombre').value = "";
            document.getElementById('usuario').value = "";
            document.getElementById('password').value = "";
            this.siEditar = false;
            this.codigo = false;
        },
        async actualiza(){
            const resp = await api.getAll("clientes");
            this.allClients = resp.data;
    }

    },
    async mounted(){

        const resp = await api.getAll("clientes");
        this.allClients = resp.data;
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