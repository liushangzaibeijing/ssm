package com.soecode.lyf.mvc;

import org.junit.Test;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.handler.AbstractHandlerMethodMapping;
import org.springframework.web.servlet.mvc.SimpleControllerHandlerAdapter;

/**
 * springMVC功能的测试类
 */
public class SpringMVCTest {

    @Test
    public void coreDispatcherServlet(){
        DispatcherServlet dispatcherServlet = new DispatcherServlet();
    }


    @Test
    public void coreHandlerMapping(){
    }
    /**
     * handlerMapping 是spring处理器映射器 负责根据对应web请求信息返回处理器该请求的Controller
     * 其有一个核心方法是getHandler(HttpServlertRequest reuest) 根据请求对象获取处理其请求的
     * Handler对象 Controller会被包装成Handler
     * HandlerMapping
     *    AbstractHandlerMapping
     *      AbstractHandlerMethodMapping
     *        RequestMappingInfoHandlerMapping
     *
     *   MatchableHandlerMapping
     *       AbstractUrlHandlerMapping
     *
     *         AbstractDetectingUrlHandlerMapping
     *            BeanNameUrlHandlerMapping
     *            RequestMappingInfoHandlerMapping
     *              RequestMappingInfoHandlerMapping
     *
     *         SimpleUrlHandlerMapping
     *
     *         WelcomePageHandlerMapping
     *
     */
}
