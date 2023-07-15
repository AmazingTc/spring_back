package com.menglin.Controller;

import com.menglin.Message.RequestCode;
import com.menglin.Message.Result;
import com.menglin.Utils.dateUtil;
import com.menglin.Utils.menuUtil;
import com.menglin.entity.User;
import com.menglin.service.UserService;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/userLogin",method = RequestMethod.POST)
    public Result userLogin(@RequestBody User userOnly){
        User user = null;
        try {
            user = userService.getIdByUser(userOnly.getUsername(), userOnly.getPassword());
        }catch (Exception e){}

        if (user != null){
            System.out.println("用户：["+user.getNickname()+"]登录成功，上次登录时间是："+user.getLasttime());
            int i = userService.updateLasttime(dateUtil.getDateTime(), user.getId());
            String token = UUID.randomUUID().toString().replace("-","");
            return new Result(RequestCode.SUCCESS,user ,menuUtil.getMenu(user.getId()),token);
        }
        return new Result(RequestCode.FAILURE,"用户名或密码错误");
    }
}
