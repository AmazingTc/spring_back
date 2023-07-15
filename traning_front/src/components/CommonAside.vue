<template>
    <el-menu :default-active="$route.name"
             class="el-menu-vertical-demo"
             text-color="#22c0df"
             active-text-color="#F5B041"
             background-color="#98F0EE"
             :collapse="!isOpen"
             :router="true"
             :collapse-transition="true"
    >
        <h3>{{ isOpen ? '员工培训管理系统' : '员工培训' }}</h3>
        <el-menu-item
            v-for="(item) in noChildren" :key="item.name" :index="item.name"
            @click="changContent(item)"
        >
            <i :class="`el-icon-${item.icon}`"></i>
            <span slot="title" v-show="isOpen">{{ item.label }}</span>
        </el-menu-item>
        <el-submenu v-for="(item) in hasChildren" :key="item.label" index="item.label">
            <template slot="title">
                <i :class="`el-icon-${item.icon}`"></i>
                <span slot="title">{{ item.label }}</span>
            </template>
            <el-menu-item-group>
                <el-menu-item
                    v-for="(items) in item.children" :key="items.name" :index="items.name"
                    @click="changContent(items)"
                >
                    {{ items.label }}
                </el-menu-item>
            </el-menu-item-group>
        </el-submenu>

    </el-menu>
</template>

<script lang='js'>
import {mapState} from 'vuex'

export default {
    name: 'CommonAside',
    components: {},
    data() {
        return {
            menuData: []
        };
    },
    computed: {
        ...mapState('menuModule', ['isOpen']),
        //无子菜单
        noChildren() {
            return this.menuData.filter(item => !item.children)
        },
        //有子菜单
        hasChildren() {
            return this.menuData.filter(item => item.children)
        },

    },
    methods: {
        changContent(item) {
            this.$store.commit('menuModule/UPDATETABLELIST', item)
            this.$router.replace(item.path)
        },
        initMenu() {
            const menu = localStorage.getItem('menu')
            //过滤掉详情页
            this.menuData = JSON.parse(menu).filter(item =>{
                if(item.children){
                   return  item.children.filter(i=>i.name!=='page2')
                }
               return  item.name !== 'detail'
            })


        }
    },
    mounted() {
        this.initMenu()
    },
}
</script>
<style lang='less' scoped>
@main-color: #F5B041;
.el-menu {
    border-right: none;
    height: 100vh;

    h3 {
        text-align: center;
        color: #F4DE61;
        margin-top: 20px;
        overflow: hidden;
        text-overflow: "";
        White-space: nowrap;
    }

    .el-menu-item:hover {
        background: #48C9B0 !important;
        color: @main-color !important;
    }

}

.el-menu-vertical-demo:not(.el-menu--collapse) {
    width: 180px; //宽度自己掌握
    height: 100vh;
}

</style>