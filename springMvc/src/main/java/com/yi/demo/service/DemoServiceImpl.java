package com.yi.demo.service;

import com.yi.demo.dao.IDemoDao;
import com.yi.demo.model.Demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by point on 2016/12/10.
 */
@Service
public class DemoServiceImpl implements IDemoService {
    @Autowired
    private IDemoDao demoDao;

    /**
     * 通过id查询demo.
     *
     * @param id
     * @return demo实例.
     */
    public Demo getById(Integer id) {
        return demoDao.getById(id);
    }
}
