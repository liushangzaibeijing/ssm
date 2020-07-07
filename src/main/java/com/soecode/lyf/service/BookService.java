package com.soecode.lyf.service;

import com.soecode.lyf.entity.Book;

public interface BookService {


    Book getById(Integer bookId);


    void saveBook(Book book);
}
