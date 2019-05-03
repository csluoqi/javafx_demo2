package com.bookmanage.service;

import java.util.List;

/**
 * @author lq
 * 创建时间 2019/5/3 22:00
 **/
public interface IService<T> {
    T selectByKey(Object key);

    int save(T entity);

    int delete(Object key);

    int updateAll(T entity);

    int updateNotNull(T entity);

    List<T> selectByExample(Object example);

    //TODO 其他...
}
