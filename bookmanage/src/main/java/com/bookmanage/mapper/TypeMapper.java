package com.bookmanage.mapper;


import com.bookmanage.model.Type;
import com.bookmanage.utils.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface TypeMapper extends MyMapper<Type> {
    /**
     * 查询类型
     * @param typeName
     * @return
     */
    List<Type> selectType(@Param("typeName") String typeName);
    /*int deleteByExample(TypeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Type record);

    int insertSelective(Type record);

    List<Type> selectByExample(TypeExample example);

    Type selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Type record, @Param("example") TypeExample example);

    int updateByExample(@Param("record") Type record, @Param("example") TypeExample example);

    int updateByPrimaryKeySelective(Type record);

    int updateByPrimaryKey(Type record);*/
}