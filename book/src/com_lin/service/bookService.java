package com_lin.service;

import com_lin.pojo.book;
import com_lin.pojo.page;

import java.util.List;

public interface bookService {
    public void addBook(book book);

    public void deleteBookById(Integer id);

    public void updateBook(book book);

    public book queryBookById(Integer id);

    public List<book> queryBooks();

    public page<book> page(int pageNo, int pageSize);

    page<book> pageByPrice(int pageNo, int pageSize, int min, int max);
}
