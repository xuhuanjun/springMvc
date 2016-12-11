package com.yi.common.dao;

import java.util.List;

/**
 * Created by point on 2016/12/11.
 */
public interface BaseDao<T> {
    T getById(Integer id);

    Page<T> getByPage(T t);
}
