package com.bookmanage.mapper;

import com.bookmanage.model.Admin;

import com.bookmanage.utils.MyMapper;

public interface AdminMapper extends MyMapper<Admin> {
    int countByExample(Admin admin);
/*
    int deleteByExample(AdminExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Admin record);

    int insertSelective(Admin record);

    List<Admin> selectByExample(AdminExample example);

    Admin selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByExample(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);*/
}