package com.soecode.lyf.dao;

import com.soecode.lyf.service.DemoService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LtwTest {

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/spring/spring-ltw.xml");
        DemoService demoBean = context.getBean(DemoService.class);

        demoBean.getById(22);
    }
}
