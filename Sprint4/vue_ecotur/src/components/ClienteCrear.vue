<template>
<div>

    <div class="contenedor">
        <div>
            <h3>Crear Clientes</h3>
            <form class="formulario__registro" action="#">

                <label class="formulario__registro-inputs" for="cedula">Cédula</label>
                <input class="formulario__registro-inputs" required type="text" placeholder="Cédula" id="cedula">

                <label class="formulario__registro-inputs" for="nombre">Nombre</label>
                <input class="formulario__registro-inputs" required type="text" placeholder="Nombre del Cliente" id="nombre">

                <label class="formulario__registro-inputs" for="usuario">Usuario</label>
                <input class="formulario__registro-inputs" required type="text" placeholder="Usuario" id="usuario">

                <label class="formulario__registro-inputs" for="password">Password</label>
                <input class="formulario__registro-inputs" required type="text" placeholder="Password" id="password">


            </form>
            <div class="formulario-botones">  
                <button type="button" @click="limpiar">Limpiar</button>
                <button type="button" @click="agregarCliente">Crear Cliente</button>

            </div>
        </div>
        <div class="contenedor__listado">
            <h3>Listado de Clientes</h3>
            
        <table border="1">
            <thead>
                <tr>
                    <th>Cédula</th>
                    <th>Nombre</th>
                    <th>Usuario</th>
                    <th>Password</th>

                </tr>
            </thead>

            <tbody >
                <tr v-for="eachPackage in allClients" :key="eachPackage">
                    <td>{{eachPackage.cedula}}</td>
                    <td>{{eachPackage.nombre}}</td>
                    <td>{{eachPackage.usuario}}</td>
                    <td>{{eachPackage.password}}</td>

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
            allClients: [],

        }


    },
    methods: {

        async agregarCliente(){
            const _cedula = document.getElementById('cedula').value;
            const _nombre = document.getElementById('nombre').value;
            const _usuario = document.getElementById('usuario').value;
            const _password = document.getElementById('password').value;


            if ( _cedula != "" && _nombre != "" && _usuario != "" && _password != "" ) {
                await api.create("cliente",{cedula: _cedula, nombre: _nombre, usuario: _usuario, password: _password});
                this.actualiza();
                this.limpiar();
            } else {
                alert('Ingrese todos los datos');
            }         
        },
        limpiar(){
            document.getElementById('cedula').value = "";
            document.getElementById('nombre').value = "";
            document.getElementById('usuario').value = "";
            document.getElementById('password').value = "";
        },
        async actualiza(){
            //const resp = await api.getAll("clientes");
            const resp = await api.getAll("clientes",{token:auth.getToken()});
            this.allClients = resp.data;
    }

    },
    async mounted(){

        //const respPaq = await api.getAll("clientes");
        const respPaq = await api.getAll("clientes",{token:auth.getToken()});
        this.allClients = respPaq.data;

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