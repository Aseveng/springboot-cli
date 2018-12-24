package com.forvue.user.service;

import com.forvue.entity.user.Manager;
import com.forvue.entity.user.ManagerExample;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by gqc on 2018/12/18.
 */
@Service
public interface ManagerService {
    List<Manager> SelectAll();
}
