import Vue from 'vue'
import Router from 'vue-router'
import LoginPage from '@/components/pages/LoginPage'

Vue.use(Router);


export default new Router({
  routes: [
    {
      path: '/',
      name: 'LoginPage',
      component: LoginPage
    }
  ]
})
