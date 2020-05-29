package com.soecode.lyf.dao;


import com.soecode.lyf.entity.Book;
import com.soecode.lyf.entity.BookExample;
import org.junit.Test;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.aop.config.AopNamespaceHandler;
import org.springframework.beans.factory.annotation.Autowired;

import com.soecode.lyf.BaseTest;
import org.springframework.beans.factory.config.MapFactoryBean;
import org.springframework.transaction.config.TxNamespaceHandler;
import org.springframework.transaction.interceptor.BeanFactoryTransactionAttributeSourceAdvisor;
import org.springframework.transaction.interceptor.TransactionInterceptor;

import java.util.List;

public class BookDaoTest extends BaseTest {

	@Autowired
	private BookMapper bookDao;

	@Test
	public void testQueryById() throws Exception {
		int bookId = 1000;
		BookExample bookExample = new BookExample();
		bookExample.createCriteria().andIdEqualTo(bookId);
		List<Book> books = bookDao.selectByExample(bookExample);
	}


}
