package com.soecode.lyf.service.impl;

import com.soecode.lyf.dao.BookMapper;
import com.soecode.lyf.entity.Book;
import com.soecode.lyf.entity.BookExample;
import com.soecode.lyf.service.BookService;
import org.apache.ibatis.binding.MapperProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookMapper bookMapper;

    public Book getById(Integer bookId) {
        BookExample bookExample = new BookExample();
        bookExample.createCriteria().andIdEqualTo(bookId);
        List<Book> bookList = bookMapper.selectByExample(bookExample);

        if(bookList == null && bookList.size()<=0){
            return null;
        }
        return bookList.get(0);
    }

    @Transactional(rollbackFor = RuntimeException.class,noRollbackFor = Exception.class)
    public void saveBook(Book book) {
        //添加
        book.setAuthor("梁晓声");
        book.setName("知青");
        book.setDescption("70年代人上山下乡");
        book.setEvaluateNumber(9999);
        book.setPrice("25.86");
        book.setPublicationDate("1994-10-21");
        book.setPublisHouse("北京石榴庄出版社");
        book.setScore(9.5);
        bookMapper.insertSelective(book);
        throw new RuntimeException();
    }
}
