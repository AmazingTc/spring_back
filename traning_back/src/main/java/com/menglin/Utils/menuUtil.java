package com.menglin.Utils;

public class menuUtil {
    public static String getMenu(Integer power) {
        String menu = null;
        if (power==0){
            menu= "menu=[" +
                    "{" +
                    "path:/home," +
                    "name:houme," +
                    "label:首页," +
                    "icon:s-home," +
                    "url:Home.vue" +
                    "},"
                    +
                    "{" +
                    "path:/mall," +
                    "name:mall," +
                    "label:商品管理," +
                    "icon:video-play," +
                    "url:Mall.vue" +
                    "},"
                    +
                    "{" +
                    "path:/user," +
                    "name:user," +
                    "label:客户管理," +
                    "icon:user," +
                    "url:User.vue" +
                    "},"
                    +
                    "{" +
                    "path:/detail," +
                    "name:detail," +
                    "label:详情," +
                    "icon:setting," +
                    "url:Detail.vue" +
                    "},"
                    +
                    "{" +
                    "path:/mall," +
                    "name:mall," +
                    "label:商品管理," +
                    "icon:video-play," +
                    "url:Mall.vue" +
                    "},"
                    +
                    "{" +
                    "label:其他," +
                    "icon:location," +
                    "children:[" +
                    "{" +
                    "path:/page1," +
                    "name:page1," +
                    "label:展台," +
                    "icon:setting," +
                    "url:PageOne.vue" +
                    "},"
                    +
                    "{" +
                    "path:/page2," +
                    "name:page2," +
                    "label:搜索详情," +
                    "icon:setting," +
                    "url:PageTwo.vue" +
                    "}"
                    +
                    "]"
                    +
                    "}"
                    +
                    "]";
        }else {
            menu= "[{" +
                    "path:/home," +
                    "name:houme," +
                    "label:首页," +
                    "icon:s-home," +
                    "url:Home.vue" +
                    "},"+
                    "{" +
                    "path:/page1," +
                    "name:page1," +
                    "label:展台," +
                    "icon:setting," +
                    "url:PageOne.vue" +
                    "}," +
                    "[{" +
                    "path:detail," +
                    "name:detail," +
                    "label:详情," +
                    "icon:setting," +
                    "url:Detail.vue" +
                    "}]";
        }

        return menu;
    }
}
