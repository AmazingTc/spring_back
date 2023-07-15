<template>
    <el-container>
        <el-aside width="auto">
            <common-aside />
        </el-aside>
        <el-container>
            <el-header>
                <Header />
            </el-header>
            <el-main>
                <CommonTag/>
                <router-view></router-view>
            </el-main>
        </el-container>
    </el-container>
</template>

<script lang="js">
import CommonAside from '@/components/CommonAside.vue'
import CommonTag from "@/components/CommonTag";
import Header from "@/components/Header";
export default {
    name: 'Main',
    components: { CommonAside,CommonTag,Header },
    data() {
        return {

        }
    },
    computed: {
    },
    watch: {},
    methods: {

    },
    created() {

    },
    mounted() {

    },
}
</script>
<style type="css" scoped>
.el-header{
    padding:0;
}
.el-main{
    padding:10px;
}
</style>