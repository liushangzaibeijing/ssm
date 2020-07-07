package com.soecode.lyf.beanFactory;

import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

public class ApplicationContextTest {

    /**
     * ApplicationContext分析
     * 之前在刚开始接触spring源码的容器类我们主要分析了XmlBeanFactory（现在我们发现该类已经被spring官方声明为过时了）
     * 我们在现实场景中最常用的其实是ApplicationContext的体系实现类，该接口和BeanFactory一样都是Spring用来管理bean实例的
     * 容器对象，但是ApplicationContext提供的功能更丰富和实用。话不多少下面让我们来一起了解一下ApplicationContext实例
     */

    @Test
    public void start(){
//        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("spring/spring-all.xml"));
//        //获取数据源实例对象
//        DataSource dataSource = beanFactory.getBean("dataSource", DataSource.class);
//        System.out.println(dataSource.toString());

        ApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"spring/spring-dao.xml","spring/spring-service.xml","spring/spring-web.xml"});
        DataSource dataSource1 = context.getBean("dataSource", DataSource.class);
        System.out.println(dataSource1.toString());
    }

    //相比于XmlBeanFactory ApplicationContext的ClassPathXmlApplicationContext，支持加载多个资源文件


    /**
     * ClassPathXmlApplicationContext的构造函数
     * @param configLocations 配置资源数组
     * @param refresh 是否刷新容器标识（该标识对应的刷新接口是该实例的核心方法）
     * @param parent  父类的对象
     * @throws BeansException
     */
    public ClassPathXmlApplicationContext(String[] configLocations, boolean refresh, ApplicationContext parent) throws BeansException {
        //设置其父类实例
        super(parent);
        //添加并解析资源名称 （数组）  //针对特殊属性的的资源名比如${var} 会进行相关的变量解析。
        this.setConfigLocations(configLocations);
        if (refresh) {
            //刷新容器接口
            this.refresh();
        }

    }

}
