package com.soecode.lyf.service.impl;

import com.soecode.lyf.dao.BookMapper;
import com.soecode.lyf.entity.Book;
import com.soecode.lyf.entity.BookExample;
import com.soecode.lyf.rollback.MyRollback;
import com.soecode.lyf.service.BookService;
import org.springframework.aop.config.AopNamespaceHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.config.TxNamespaceHandler;
import org.springframework.transaction.interceptor.BeanFactoryTransactionAttributeSourceAdvisor;

import java.util.List;

@Service
public class BookServiceImpl implements  BaseService ,BookService {

    @Autowired
    BookMapper bookMapper;


    @Override
    public Book getById(Integer bookId) {
        BookExample bookExample = new BookExample();
        bookExample.createCriteria().andIdEqualTo(bookId);
        List<Book> bookList = bookMapper.selectByExample(bookExample);

        if(bookList == null && bookList.size()<=0){
            return null;
        }
        return bookList.get(0);
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void saveBook(Book book)  {
        book.setAuthor("梁晓声");
        book.setName("知青");
        book.setDescption("70年代人上山下乡");
        book.setEvaluateNumber(9999);
        book.setPrice("25.86");
        book.setPublicationDate("1994-10-21");
        book.setPublisHouse("北京石榴庄出版社");
        book.setScore(9.5);
        bookMapper.insertSelective(book);
        throw new RuntimeException("保存书籍失败");
    }
}
