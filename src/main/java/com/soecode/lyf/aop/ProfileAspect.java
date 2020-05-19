package com.soecode.lyf.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.util.StopWatch;

@Aspect
public class ProfileAspect {
    @Around(value = "profileMethod()")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable {
        StopWatch sw = new StopWatch(getClass().getName());
        try {
            sw.start(pjp.getSignature().getName());
            return pjp.proceed();
        } finally {
            sw.stop();
            System.err.println(sw.prettyPrint());
        }
    }
    @Pointcut("execution(* com.soecode.lyf.service.impl.*.*(..))")
    public void profileMethod() {
        System.out.println("profileMethod..");
    }
}