package com.soecode.lyf.dao;


import com.soecode.lyf.entity.Book;
import com.soecode.lyf.service.DemoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.beans.AbstractPropertyAccessor;
import org.springframework.beans.factory.annotation.Autowired;

import com.soecode.lyf.BaseTest;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sound.midi.Instrument;

//指定在单元测试启动的时候创建spring的工厂类对象
@ContextConfiguration(locations = {"classpath:spring/spring-service.xml"})
//RunWith的value属性指定以spring test的SpringJUnit4ClassRunner作为启动类
//如果不指定启动类，默认启用的junit中的默认启动类
@RunWith(value = SpringJUnit4ClassRunner.class)
public class BookDaoTest extends BaseTest {
	@Autowired
	private DemoService demoService;
	@Test
	public void testQueryById() throws Exception {
		int bookId = 2446;
        Book book = demoService.getById(bookId);
        System.out.println("书籍信息为："+book);

		book = demoService.getById(bookId);
		System.out.println("书籍信息为："+book);




    }
}
