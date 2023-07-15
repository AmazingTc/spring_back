package com.menglin.dao;

import com.menglin.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserDao {

    @Select("select id,nickname,username,power,lasttime from user where username=#{username} and password = #{password}")
    public User getIdByUser(String username, String password) throws Exception;

    @Update("update user set lasttime = #{lasttime} where id = #{id}")
    public int updateLasttime(String lasttime,Integer id);
}
