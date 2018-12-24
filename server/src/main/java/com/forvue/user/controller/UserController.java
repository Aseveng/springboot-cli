package com.forvue.user.controller;

import com.forvue.entity.user.Manager;
import com.forvue.entity.user.User;
import com.forvue.user.service.ManagerService;
import com.forvue.user.service.UserService;
import com.forvue.utils.Md5Encrypt;
import com.forvue.utils.R;
import com.forvue.utils.ShiroUtils;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @Autowired
    ManagerService managerService;
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
     * @param
     */
    @RequestMapping("/registe")
    @ResponseBody
    public void registe(@RequestBody User user){
        userService.insert(user);
    }


    /**
     *
     */
    @GetMapping("/ManagerList")
    @ResponseBody
    public R listManager(){
        List<Manager> list=managerService.SelectAll();
        R r=R.ok();
        r.put("data",list);
        return r;
    }
}
