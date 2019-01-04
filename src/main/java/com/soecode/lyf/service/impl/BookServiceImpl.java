package com.soecode.lyf.service.impl;

import com.soecode.lyf.dao.BookMapper;
import com.soecode.lyf.entity.Book;
import com.soecode.lyf.entity.BookExample;
import com.soecode.lyf.service.BookService;
import org.apache.ibatis.binding.MapperProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.stereotype.Service;

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
}
