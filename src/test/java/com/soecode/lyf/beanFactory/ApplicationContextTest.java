package com.soecode.lyf.beanFactory;

import com.soecode.lyf.config.MyTaskEvent;
import com.soecode.lyf.entity.Book;
import com.soecode.lyf.service.impl.DemoServiceImpl;
import com.soecode.lyf.service.impl.DemoTwoServiceImpl;
import com.soecode.lyf.service.impl.EnvService;
import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.PropertyEditorRegistrySupport;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.support.ResourceEditorRegistrar;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;
import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;
import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;

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

    //ApplicationContext的refresh()方法
    @Test
    public void preparRefresh(){
        MyClassPathXmlApplicationContext context = new MyClassPathXmlApplicationContext("spring/spring-dao.xml");
        String classPath = context.getEnvironment().getProperty("classPath");
        System.out.println("系统路径："+classPath);

    }
    //自定义ApplictionContext
    //业务场景对于容器启动需要设置相关系统属性，且对系统属性进行校验，则此处重写了initPropertySources（）方法
    //扩展添加了属性信息  且添加了一个必填参数的校验
    class MyClassPathXmlApplicationContext extends ClassPathXmlApplicationContext{

        MyClassPathXmlApplicationContext(String... configLocations){
            super(configLocations);
        }
        @Override
        protected void initPropertySources() {
           //此处进行
            //系统变量
            String classPath = "/usr/local/jdk1.9/bin";
            Map<String,Object> paramMap = new HashMap<String, Object>();
            paramMap.put("classPath",classPath);
            SystemEnvironmentPropertySource seps = new SystemEnvironmentPropertySource("env", paramMap);
            //设置必填属性
            getEnvironment().getPropertySources().addFirst(seps);
            getEnvironment().setRequiredProperties("classPath");
            //设置环境中的必填参数alis校验 但是初始化属性中没有该属性会报错
//            getEnvironment().setRequiredProperties("alis");
        }
    }

    //测试beanFactory实例化
    @Test
    public void obtainFreshBeanFactory(){
//        ApplicationContext context = new ClassPathXmlApplicationContext(
//                new String[]{"spring/spring-beans.xml"});
        ApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"spring/spring-bean2.xml","spring/spring-bean1.xml"});
        Object object = context.getBean("demoService");
        System.out.println(object.toString());
    }


    //测试beanFactory实例化
    @Test
    public void prepaerBeanFactory() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"spring/spring-env.xml"});
        EnvService envService = context.getBean("envService", EnvService.class);
        envService.printProp();
    }

    //测试SpEL的使用
    @Test
    public void spELTest() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"spring/spring-el.xml"});
        Book book = context.getBean("bookTwo", Book.class);
        System.out.println(book.getName());
    }

    //测试bean后置处理器的使用
    @Test
    public void beanPostProcessorTest() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"spring/spring-beanPostProcessor.xml","spring/spring-bean1.xml"});
        DemoServiceImpl demoService = context.getBean("demoService", DemoServiceImpl.class);

    }

    //测试事件监听器
    @Test
    public void listnerTest() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"spring/spring-listener.xml"});

        //创建事件
        MyTaskEvent taskEvent = new MyTaskEvent("test","404","资源未找");
        context.publishEvent(taskEvent);
    }




}
