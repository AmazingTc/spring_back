<template>
  <div id="app">
    <router-view></router-view>
  </div>
</template>

<script>

export default {
  name: 'App',
}
</script>

<style lang="less">
//@main-color: #98F0EE;
//body{
//    background-color: @main-color;
//}
*{
    margin:0;
    padding:0;
    box-sizing: border-box;
    border:none;
}
body{
    overflow: hidden;
}
.el-card__body, .el-main {
    padding:0;
}

</style>
