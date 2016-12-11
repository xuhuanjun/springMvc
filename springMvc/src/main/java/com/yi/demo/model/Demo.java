package com.yi.demo.model;

import java.io.Serializable;

/**
 * Created by point on 2016/12/10.
 */
public class Demo implements Serializable {
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
