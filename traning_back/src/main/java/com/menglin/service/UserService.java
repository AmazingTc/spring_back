package com.menglin.service;

import com.menglin.entity.User;

public interface UserService {

    //根据用户名和密码返回除了密码的所有信息
    User getIdByUser(String username, String password) throws Exception;

    // 更改登录时间
    public int updateLasttime(String lasttime,Integer id);
}
