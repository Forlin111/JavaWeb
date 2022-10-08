package com_lin.dao;

import com_lin.pojo.book;

import java.util.List;

public interface bookDao {
    public int addBook(book book);

    public int deleteBookById(Integer id);

    public int updateBook(book book);

    public book queryBookById(Integer id);

    public List<book> queryBooks();

    Integer queryForPageTotalCount();

    List<book> queryForPageItems(int begin, int pageSize);

    Integer queryForPageTotalCountByPrice(int min, int max);

    List<book> queryForPageItemsByPrice(int begin, int pageSize, int min, int max);
}
