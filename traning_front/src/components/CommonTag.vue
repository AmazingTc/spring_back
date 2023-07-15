<template>
    <div class="tag">
        <el-tag
            v-for="item in tableList"
            :key="item.name"
            closable
            :closable="item.name!=='home'"
            :type="$route.name===item.name?'warning':'info'"
            @close="handleClose(item)"
            @click="changeMenu(item)"
        >
                {{item.label}}
        </el-tag>
    </div>
</template>

<script>
import {mapState} from 'vuex'
export default {
    name: "CommonTag",
    computed:{
        ...mapState('menuModule',['tableList'])
    },
    methods:{
        handleClose(item){
            this.$store.commit('menuModule/DELETETAG',item)
            this.$router.push(this.tableList[this.tableList.length-1].path)
        },
        changeMenu(item){
            this.$router.push(item.path)
        }
    },
    mounted() {

    }
}
</script>

<style lang="less" scoped>
.tag{
    width: 100%;
    height:30px;
    .el-tag{
        margin-right:10px;
        height: 30px;
        line-height: 30px;
    }
    .el-tag:hover{
        cursor: pointer;
    }
}
</style>