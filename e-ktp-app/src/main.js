import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'

Vue.config.productionTip = false


import 'admin-lte/plugins/fontawesome-free/css/all.min.css'
import 'admin-lte/plugins/icheck-bootstrap/icheck-bootstrap.min.css'
import 'admin-lte/dist/css/adminlte.min.css?v=3.2.0'
import './style.scss'

import 'admin-lte/plugins/jquery/jquery.min.js'
import 'admin-lte/plugins/bootstrap/js/bootstrap.bundle.min.js'
import 'admin-lte/dist/js/adminlte.min.js?v=3.2.0'

/* ------------ Global Components -------------- */
import AppNavBar from './components/AppNavBar'
import AppSideBar from './components/AppSideBar'
import AppSuccess from './components/AppSuccess'
import VueSimpleAlert from 'vue-simple-alert'


Vue.component('AppNavBar', AppNavBar)
Vue.component('AppSideBar', AppSideBar)
Vue.component('AppSuccess', AppSuccess)

Vue.use(VueSimpleAlert)


new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
