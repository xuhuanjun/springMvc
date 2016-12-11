package com.yi.demo.dao;

import com.yi.demo.model.Demo;

/**
 * Created by point on 2016/12/10.
 */
public interface IDemoDao {
    /**
     * 通过id查询demo.
     *
     * @param id
     * @return
     */
    Demo getById(Integer id);
}
