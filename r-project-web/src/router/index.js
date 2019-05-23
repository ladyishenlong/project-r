import Vue from 'vue'
import Router from 'vue-router'
import TestPage from "../components/pages/TestPage";
import LoginPage from "../components/pages/LoginPage";
import ArticleIndexPage from "../components/pages/ArticleIndexPage";

Vue.use(Router);


export default new Router({
  routes: [
    {path: '/', name: 'LoginPage', component: LoginPage},
    {path: '/test', name: 'TestPage', component: TestPage},
    {path: '/articleIndex', name: 'ArticleIndexPage', component: ArticleIndexPage}
  ]
})
