package com.yi.demo.controller;

import com.yi.demo.model.Demo;
import com.yi.demo.service.IDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by point on 2016/12/7.
 */
@RestController
@RequestMapping("/demo")
public class DemoController {
    @Autowired
    private IDemoService demoService;

    @RequestMapping(value = "/getWebRoot", method = RequestMethod.GET)
    public String getWebRoot() {
        return "hello spring-mvc";
    }

    @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
    public Demo getById(@PathVariable Integer id) {
        return demoService.getById(id);
    }
}
