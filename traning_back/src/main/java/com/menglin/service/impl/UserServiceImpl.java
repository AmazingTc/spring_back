package com.menglin.service.impl;

import com.menglin.dao.UserDao;
import com.menglin.entity.User;
import com.menglin.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public User getIdByUser(String username, String password) throws Exception{
        return userDao.getIdByUser(username,password) ;
    }

    @Override
    public int updateLasttime(String lasttime, Integer id) {
        return userDao.updateLasttime(lasttime,id);
    }
}
