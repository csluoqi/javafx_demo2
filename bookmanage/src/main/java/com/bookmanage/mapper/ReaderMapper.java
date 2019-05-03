package com.bookmanage.mapper;

import com.bookmanage.model.Reader;

import com.bookmanage.utils.MyMapper;

public interface ReaderMapper extends MyMapper<Reader> {
    int countByExample(Reader example);
/*
    int deleteByExample(ReaderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Reader record);

    int insertSelective(Reader record);

    List<Reader> selectByExample(ReaderExample example);

    Reader selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Reader record, @Param("example") ReaderExample example);

    int updateByExample(@Param("record") Reader record, @Param("example") ReaderExample example);

    int updateByPrimaryKeySelective(Reader record);

    int updateByPrimaryKey(Reader record);*/
}