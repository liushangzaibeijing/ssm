package com.soecode.lyf.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.aop.config.AopNamespaceHandler;
import org.springframework.beans.factory.support.AbstractBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.stereotype.Component;
import org.springframework.test.context.support.AbstractGenericContextLoader;

/**
 * 日志打印切面
 */
@Aspect
@Component
public class LogAspect {
    //在进入切点业务代码未执行之前执行
    @Before("execution(* com.soecode.lyf.service.impl.*.*(..))")
    public void logBefore(JoinPoint pjp){
        MethodSignature methodSignature = ( MethodSignature) pjp.getSignature();
        String methodName = methodSignature.getMethod().getName();
        String className = pjp.getTarget().getClass().getName();
        Object[] argsInfo = pjp.getArgs();
        System.out.println("日志打印开始 class info : "+className+", method info : "+methodName+", args info: "+argsInfo);
    }

    //在执行完切点后执行
    @After("execution(* com.soecode.lyf.service.impl.*.*(..))")
    public void logAfter(JoinPoint pjp){
        MethodSignature methodSignature = ( MethodSignature) pjp.getSignature();
        String methodName = methodSignature.getMethod().getName();
        String className = pjp.getTarget().getClass().getName();
        Object[] argsInfo = pjp.getArgs();
        System.out.println("日志打印结束 class info : "+className+", method info : "+methodName+", args info: "+argsInfo);

    }
}
