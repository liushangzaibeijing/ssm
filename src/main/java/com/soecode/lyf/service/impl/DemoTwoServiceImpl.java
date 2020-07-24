package com.soecode.lyf.service.impl;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Service;

public class DemoTwoServiceImpl {
    public void destroyBeanTest() throws Exception {
        System.out.println("[DemoTwoServiceImpl]实例的销毁方法");
    }
}
