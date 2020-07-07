package com.soecode.lyf.service;

import com.soecode.lyf.BaseTest;
import com.soecode.lyf.entity.Book;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TxTest extends BaseTest {

    @Autowired
    private BookService bookService;

    @Test
    public void testTx(){
        Book book = new Book();
        bookService.saveBook(book);
    }

    @Test
    public void testNOtTx(){

        bookService.getById(100);
    }
}

