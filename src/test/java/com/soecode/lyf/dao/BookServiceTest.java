package com.soecode.lyf.dao;


import com.soecode.lyf.BaseTest;
import com.soecode.lyf.entity.Book;
import com.soecode.lyf.entity.BookExample;
import com.soecode.lyf.service.BookService;
import org.junit.Test;
import org.springframework.aop.aspectj.autoproxy.AspectJAwareAdvisorAutoProxyCreator;
import org.springframework.aop.config.AopNamespaceHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.config.TxNamespaceHandler;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.transaction.interceptor.TransactionInterceptor;

import java.util.List;

public class BookServiceTest extends BaseTest {

	@Autowired
	private BookService bookService;

	/**
	 * 测试事务的回滚操作
	 * @throws Exception
	 */
	@Test
	public void testTranstion() throws Exception {
	   bookService.saveBook(new Book());
	}


}
