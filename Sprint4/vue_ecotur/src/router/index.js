import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";
import Login from "../views/Login.vue";
import Paquetes from "../views/Paquetes.vue";
import Index from "../views/Index.vue";
import Cundinamarca from "../views/Cundinamarca.vue";
import Listado from "../views/Listado.vue";


Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },
  {
    path: "/login",
    name: "Login",
    component: Login,
  },
  {
    path: "/paquetes",
    name: "Paquetes",
    component: Paquetes,
  },

   {
    path: "/index",
    name: "index",
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
