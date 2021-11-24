import { createRouter, createWebHistory } from 'vue-router'
import Home from '../views/Home.vue'
import Reserva from '../views/Reserva.vue'
import Login from  '@/views/Login.vue'
import isAutenticado  from './auth'
import isAutenticadop  from './authp'

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/reserva',
    name: 'Reserva',
    component: Reserva,
    beforeEnter: [isAutenticado]
    
  },

  {
    path: '/login',
    name: 'Login',
    component: Login
    
  },
  {
    path: '/paquete',
    name: 'Paquete',
    component: () => import(/* webpackChunkName: "about" */ '../views/Paquete.vue'),
    beforeEnter: [isAutenticadop]
  },
  {
    path: '/cliente',
    name: 'Cliente',
    component: () => import(/* webpackChunkName: "about" */ '../views/Cliente.vue'),
    beforeEnter: [isAutenticadop]
  },
  {
    path: '/costa',
    name: 'Costa',
    component: () => import(/* webpackChunkName: "about" */ '../views/Costa.vue'),
    beforeEnter: [isAutenticado]
  },
  {
    path: '/boyaca',
    name: 'Boyaca',
    component: () => import(/* webpackChunkName: "about" */ '../views/Boyaca.vue')
  },
  {
    path: '/caldas',
    name: 'Caldas',
    component: () => import(/* webpackChunkName: "about" */ '../views/Caldas.vue')
  },
  {
    path: '/cundinamarca',
    name: 'Cundinamarca',
    component: () => import(/* webpackChunkName: "about" */ '../views/Cundinamarca.vue')
  },
  {
    path: '/santander',
    name: 'Santander',
    component: () => import(/* webpackChunkName: "about" */ '../views/Cundinamarca.vue')
  },

  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
