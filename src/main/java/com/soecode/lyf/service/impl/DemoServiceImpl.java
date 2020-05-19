package com.soecode.lyf.service.impl;

import com.soecode.lyf.entity.Book;
import com.soecode.lyf.service.DemoService;
import org.springframework.stereotype.Service;


@Service
public class DemoServiceImpl implements DemoService {
    public Book getById(Integer bookId) {
       Book book = new Book();
       book.setName("四世同堂");
       book.setAuthor("老舍");
       return  book;
    }
}
