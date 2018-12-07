package com.forvue.utils;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * Created by gqc on 2018/11/28.
 */
@Component
public class ShiroUtils {
    @Autowired
    Md5Encrypt md5Encrypt;
    public String login( String username, String password) {
        //1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager
        Factory<SecurityManager> factory =
                new IniSecurityManagerFactory("classpath:shiro-jdbc-realm.ini");

        //2、得到SecurityManager实例 并绑定给SecurityUtils
        org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        //3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            token.getPassword();
            //4、登录，即身份验证
            //String newPassword=md5Encrypt.encryptPassword(subject);
            subject.login(token);
            return "登录成功";
        } catch (AuthenticationException e) {
            //5、身份验证失败
            return "登录失败";

        }
    }
    public Subject subject() {
        return SecurityUtils.getSubject();
    }
}
