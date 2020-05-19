package com.soecode.lyf.web;

import com.soecode.lyf.entity.Book;
import com.soecode.lyf.service.DemoService;
import org.springframework.aop.framework.ReflectiveMethodInvocation;
import org.springframework.aop.framework.adapter.MethodBeforeAdviceInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value = 10)
public class AgentApplicationRun implements ApplicationRunner {

    @Autowired
    private DemoService demoService;
    public void run(ApplicationArguments applicationArguments) throws Exception {
        Book book = demoService.getById(2446);
    }
}
