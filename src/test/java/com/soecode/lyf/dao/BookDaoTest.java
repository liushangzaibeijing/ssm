package com.soecode.lyf.dao;


import com.soecode.lyf.entity.Book;
import com.soecode.lyf.entity.BookExample;
import org.junit.Test;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.soecode.lyf.BaseTest;

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
