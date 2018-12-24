package com.forvue.user.service.impl;

import com.forvue.entity.user.Manager;
import com.forvue.entity.user.ManagerExample;
import com.forvue.user.dao.ManagerMapper;
import com.forvue.user.service.ManagerService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by gqc on 2018/12/18.
 */
@Service("ManagerService")
public class ManagerServiceImpl implements ManagerService{
    @Autowired
    ManagerMapper managerMapper;

    @Autowired
    ManagerExample managerExample;

    //查询所有的管理员
    @Override
    public List<Manager> SelectAll() {
        return managerMapper.selectByExample(managerExample);
    }
}
