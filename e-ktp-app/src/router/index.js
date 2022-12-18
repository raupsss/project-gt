import Vue from 'vue'
import VueRouter from 'vue-router'
// import HomeView from '../views/HomeView.vue'

Vue.use(VueRouter)

const routes = [
  // {
  //   path: '/',
  //   name: 'home',
  //   component: HomeView
  // },
  // {
  //   path: '/about',
  //   name: 'about',
  //   // route level code-splitting
  //   // this generates a separate chunk (about.[hash].js) for this route
  //   // which is lazy-loaded when the route is visited.
  //   component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  // }
  {
    path: '/home',
    // name: 'DefaultLayout',
    component: () => import('../layouts/DefaultLayout'),
    children: [
      {
        path: '/home',
        name: 'HomePage',
        component: () => import('../views/HomeView')
      },
      {
        path: '/addKK',
        name: 'AddPage',
        component: () => import('../views/AddView')
      },
      {
        path: '/detailKK/:id',
        name: 'DetailPage',
        component: () => import('../views/DetailView')
      },
      {
        path: '/detailKK/:id/listAnggota',
        name: 'ListAnggota',
        component: () => import('../views/ListAnggota')
      },
      {
        path: '/detailKK/:id/listAnggota/detailAnggota/:idAnggota',
        name: 'DetailAnggota',
        component: () => import('../views/DetailAnggota')
      }

    ]
  },
  {
    path: '',
    // name: 'DefaultLayout',
    component: () => import('../layouts/BlankLayout'),
    children: [
      {
        path: '/',
        name: 'LoginPage',
        component: () => import('../views/auth/Login')
      }
    ]
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
