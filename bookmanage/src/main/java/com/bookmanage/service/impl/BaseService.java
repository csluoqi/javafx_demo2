package com.bookmanage.service.impl;

import com.bookmanage.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author lq
 * 创建时间 2019/5/3 22:00
 **/
public abstract class BaseService<T> implements IService<T> {

    @Autowired
    protected Mapper<T> mapper;

    public Mapper<T> getMapper() {
        return mapper;
    }

    public T selectByKey(Object key) {
        return mapper.selectByPrimaryKey(key);
    }

    public int save(T entity) {
        return mapper.insert(entity);
    }

    public int delete(Object key) {
        return mapper.deleteByPrimaryKey(key);
    }

    public int updateAll(T entity) {
        return mapper.updateByPrimaryKey(entity);
    }

    public int updateNotNull(T entity) {
        return mapper.updateByPrimaryKeySelective(entity);
    }

    public List<T> selectByExample(Object example) {
        return mapper.selectByExample(example);
    }

    //TODO 其他...
}
