package com.forvue.user.service.impl;

import com.forvue.entity.user.User;
import com.forvue.user.dao.UserDao;
import com.forvue.user.service.UserService;
import com.forvue.utils.Md5Encrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by gqc on 2018/11/29.
 */
@Service("UserService")
public class UserServiceImpl implements UserService{
    @Autowired
    UserDao userMapper;
    @Autowired
    Md5Encrypt md5Encrypt;

    @Override
    public int insert(User user) {
        //密码加密
        md5Encrypt.encryptPassword(user);
        int count = userMapper.insert(user);
        return count;
    }
}
