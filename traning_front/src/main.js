import Vue from 'vue'
import App from './App.vue'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import router from '@/router'
import  '@/assets/fonts/iconfont/iconfont.css'
import store from '@/store/index'
import '@/api/mock'
Vue.use(ElementUI,{size:'mini',zIndex:1024})
Vue.config.productionTip = false
new Vue({
  router,
  store,
  render: h => h(App),
  beforeCreate() {
    Vue.prototype.$bus=this
  },
  created() {
    //重新获取路由，防止出现刷新页面后的白屏问题
    store.commit('menuModule/ADDROUTER',router)
  }
}).$mount('#app')
