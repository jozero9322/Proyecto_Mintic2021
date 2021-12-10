import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";
import Login from "../views/Login.vue";
import Paquetes from "../views/Paquetes.vue";
import Reservas from "../views/Reservas.vue";
import Index from "../views/Index.vue";
import Cundinamarca from "../views/Cundinamarca.vue";
import Listado from "../views/Listado.vue";
import Boyaca from "../views/Boyaca.vue";
import Caldas from "../views/Caldas.vue";
import Clientes from "../views/Clientes.vue";
import Costa from "../views/Costa.vue";
import Santander from "../views/Santander.vue";
import ComprasCliente from "@/views/ComprasCliente.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },
  {
    path: "/boyaca",
    name: "Boyaca",
    component: Boyaca,
  },
  {
    path: "/caldas",
    name: "Caldas",
    component: Caldas,
  },
  {
    path: "/clientes",
    name: "Clientes",
    component: Clientes,
  },
  {
    path: "/costa",
    name: "Costa",
    component: Costa,
  },
  {
    path: "/santander",
    name: "Santander",
    component: Santander,
  },
  {
    path: "/login",
    name: "Login",
    component: Login,
  },
  {
    path: "/compras_cliente",
    name: "ComprasCliente",
    component: ComprasCliente,
  },
  {
    path: "/paquetes",
    name: "Paquetes",
    component: Paquetes,
  },
  {
    path: "/reservas",
    name: "Reservas",
    component: Reservas,
  },

  {
    path: "/index",
    name: "Index",
    component: Index,
  },
   
   {
    path: "/cundinamarca",
    name: "cundinamarca",
    component: Cundinamarca,
  },
  {
    path: "/listado-paquetes",
    name: "listado-paquetes",
    component: Listado,
  },
  {
    path: "/about",
    name: "About",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/About.vue"),
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
