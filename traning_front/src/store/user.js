export default {
    namespaced:true,
    mutations:{
        SAVEUSER(state,data){
            state.userInfo=data
            localStorage.setItem('userInfo',JSON.stringify(data))
        }
    },
    state:{
        userInfo:null
    }
}