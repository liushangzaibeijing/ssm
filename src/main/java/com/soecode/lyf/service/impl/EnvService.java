package com.soecode.lyf.service.impl;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

public class EnvService implements EnvironmentAware {
     private Environment environment;
     public void setEnvironment(final Environment environment) {
        this.environment = environment;
    }

    public void printProp() throws Exception {
        System.out.println("java.runtime.name:"+environment.getProperty("java.runtime.name"));
    }


}