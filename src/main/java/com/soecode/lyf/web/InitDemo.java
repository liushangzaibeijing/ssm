package com.soecode.lyf.web;

import com.soecode.lyf.entity.Book;
import com.soecode.lyf.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class InitDemo{

    @Autowired
    private DemoService demoService;
    @PostConstruct
    public void init() {
        //项目启动就会执行这个方法
        Book book = demoService.getById(2446);
    }
}
