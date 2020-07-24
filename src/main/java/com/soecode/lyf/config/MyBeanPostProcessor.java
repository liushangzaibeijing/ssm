package com.soecode.lyf.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * bean后置处理器
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
    /**
     * bean后置处理器的前置方法
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(beanName+"调用MyBeanPostProcessor类的前置方法");
        return bean;
    }

    /**
     * bean后置处理器的后置方法
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(beanName+"调用MyBeanPostProcessor类的后置方法");
        return bean;
    }
}
