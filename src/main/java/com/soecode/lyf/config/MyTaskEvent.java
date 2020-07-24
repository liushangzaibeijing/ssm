package com.soecode.lyf.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.event.SpringApplicationEvent;
import org.springframework.context.ApplicationEvent;

public class MyTaskEvent extends ApplicationEvent {
    private String code;

    public MyTaskEvent(Object source, String code, String msg) {
        super(source);
        this.code = code;
        this.msg = msg;
    }

    private String msg;

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public MyTaskEvent(Object source) {
        super(source);
    }



    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
