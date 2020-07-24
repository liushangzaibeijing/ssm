package com.soecode.lyf.config;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class MySpringListerner implements ApplicationListener {
    public void onApplicationEvent(ApplicationEvent event) {
        if(event instanceof MyTaskEvent){
            MyTaskEvent taskEvent = (MyTaskEvent) event;
            System.out.println("触发MyTaskEvent事件，code:"+taskEvent.getCode()+",msg:"+taskEvent.getMsg());
        }
    }
}
