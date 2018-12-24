package com.forvue.user.dao;

import com.forvue.entity.user.Manager;
import com.forvue.entity.user.ManagerExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ManagerMapper {
    long countByExample(ManagerExample example);

    int deleteByExample(ManagerExample example);

    int deleteByPrimaryKey(String id);

    int insert(Manager record);

    int insertSelective(Manager record);

    List<Manager> selectByExample(ManagerExample example);

    Manager selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Manager record, @Param("example") ManagerExample example);

    int updateByExample(@Param("record") Manager record, @Param("example") ManagerExample example);

    int updateByPrimaryKeySelective(Manager record);

    int updateByPrimaryKey(Manager record);
    int selectAall();
}