// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'

import iView from 'iview';
import 'iview/dist/styles/iview.css';

import axios from 'axios'

Vue.config.productionTip = false;
Vue.use(iView);
Vue.prototype.$axios = axios;

// axios.defaults.headers.get['x-auth-token'] = "SESSION=ODg1YmI2ODYtN2JkYS00ZWY3LWExMDAtODg0OWU3NDZlMWNk";
// document.cookie="SESSION=NTlmYWZkMTItMTg0Yy00ODQ3LWJmOTUtNTBhYTA2NmM4ZDZl";
// // document.domain="localhost";
// axios.defaults.withCredentials = true;



/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: {App},
  template: '<App/>'
});
