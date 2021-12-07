import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";
import Login from "../views/Login.vue";
import Paquetes from "../views/Paquetes.vue";
import Boyaca from "../views/Boyaca.vue";
import Caldas from "../views/Caldas.vue";
import Cliente from "../views/Cliente.vue";
import Costa from "../views/Costa.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },
  {
    path: "/Boyaca",
    name: "Boyaca",
    component: Boyaca,
  },
  {
    path: "/caldas",
    name: "Caldas",
    component: Caldas,
  },
  {
    path: "/Cliente",
    name: "Cliente",
    component: Cliente,
  },
  {
    path: "/Costa",
    name: "Costa",
    component: Costa,
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
