package com.yi.demo.service;

import com.yi.demo.model.Demo;
import org.springframework.stereotype.Service;

/**
 * Created by point on 2016/12/10.
 */
public interface IDemoService {
    /**
     * 通过id查询demo.
     *
     * @param id
     * @return
     */
    Demo getById(Integer id);
}
