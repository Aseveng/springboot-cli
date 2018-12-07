package com.forvue.user.controller;

import com.forvue.entity.user.User;
import com.forvue.user.service.UserService;
import com.forvue.utils.Md5Encrypt;
import com.forvue.utils.ShiroUtils;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by gqc on 2018/11/27.
 */
@RestController
public class UserController {

    @Autowired
    ShiroUtils shiroUtils;

    @Autowired
    Md5Encrypt md5Encrypt;

    @Autowired
    UserService userService;

    /**
     * 用户登录
     *
     */
    @RequestMapping("/login")
    public  String login(@RequestBody Map<String,Object>map){
        String username= (String) map.get("username");
        String password= (String) map.get("password");
        return shiroUtils.login(username,password);

    }

    /**
     * 注册
     * 加密密码
     * @param map
     */
    @RequestMapping("/registe")
    @ResponseBody
    public void registe(@RequestBody User user){
        userService.insert(user);
    }

}
