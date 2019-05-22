import Vue from 'vue'
import Router from 'vue-router'
import TestPage from "../components/pages/TestPage";
import LoginPage from "../components/pages/LoginPage";

Vue.use(Router);


export default new Router({
  routes: [
    {path: '/', name: 'LoginPage', component: LoginPage},
    {path: '/test', name: 'TestPage', component: TestPage}
  ]
})
