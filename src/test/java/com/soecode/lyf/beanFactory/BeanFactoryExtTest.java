package com.soecode.lyf.beanFactory;

import com.soecode.lyf.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;

/**
 * BeanFactory的扩展类ApplicationContext的相关功能
 */
public class BeanFactoryExtTest {

    /**
     * 比较XmlBeanFactory和ApplicationContext
     * 两者启动的配置
     */
    @Test
    public void start(){
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("spring/spring-all.xml"));
        //获取数据源实例对象
        DataSource dataSource = beanFactory.getBean("dataSource", DataSource.class);
        System.out.println(dataSource.toString());
        ApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"spring/spring-dao.xml","spring/spring-service.xml","spring/spring-web.xml"});
        DataSource dataSource1 = context.getBean("dataSource", DataSource.class);
        System.out.println(dataSource.toString());
    }
}
