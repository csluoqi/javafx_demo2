package com.bookmanage.mapper;

import com.bookmanage.model.Book;

import com.bookmanage.utils.MyMapper;

public interface BookMapper extends MyMapper<Book> {
    int countByExample(Book book);
/*
    int deleteByExample(BookExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Book record);

    int insertSelective(Book record);

    List<Book> selectByExample(BookExample example);

    Book selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Book record, @Param("example") BookExample example);

    int updateByExample(@Param("record") Book record, @Param("example") BookExample example);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);*/
}