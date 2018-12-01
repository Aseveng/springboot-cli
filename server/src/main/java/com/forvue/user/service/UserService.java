package com.forvue.user.service;

import com.forvue.entity.user.User;
import org.springframework.stereotype.Service;

/**
 * Created by gqc on 2018/11/28.
 */
@Service
public interface UserService {
    int insert(User record);
}
