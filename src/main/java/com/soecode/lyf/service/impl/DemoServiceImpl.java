package com.soecode.lyf.service.impl;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Service;

public class DemoServiceImpl  implements DisposableBean {
    public void destroy() throws Exception {
        System.out.println("[DemoServiceImpl]实例的销毁方法");
    }
}
