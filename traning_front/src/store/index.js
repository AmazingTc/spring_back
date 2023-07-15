import Vue from 'vue'
import Vuex from 'vuex'
Vue.use(Vuex)
import userModule from '@/store/user'
import menuModule from '@/store/menu'

export default new Vuex.Store({
    modules:{
        userModule,
        menuModule
    }
})