package com_lin.test;

import com_lin.dao.bookDao;
import com_lin.dao.impl.BaseDao;
import com_lin.dao.impl.bookDaoImpl;
import com_lin.pojo.book;
import org.junit.Test;

import java.awt.print.Book;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class bookDaoTest {
    private bookDao bookDao = new bookDaoImpl();

    @Test
    public void addBook() {
        bookDao.addBook(new book(null, "hhj", "hhj", new BigDecimal(99), 100, 0, null));
    }

    @Test
    public void deleteBookById() {

    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new book(23, "黄慧静", "hhj", new BigDecimal(99), 100, 0, null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookDao.queryBookById(23));
    }

    @Test
    public void queryBooks() {
        for (book queryBook : bookDao.queryBooks()) {
            System.out.println(queryBook);
        }
    }

    @Test
    public void queryForPageTotalCount() {
        System.out.println(bookDao.queryForPageTotalCount());
    }

    @Test
    public void queryForPageTotalCountByPrice() {
        System.out.println(bookDao.queryForPageTotalCountByPrice(10,10000));
    }

    @Test
    public void queryForPageItems() {
        List<book> books = bookDao.queryForPageItems(8, 4);
        for (book book : books) {
            System.out.println(book);
            System.out.println(book.getName());
        }
    }

    @Test
    public void queryForPageItemsNyPrice() {
        List<book> books = bookDao.queryForPageItemsByPrice(1, 30,10,500);
        for (book book : books) {
            System.out.println(book);
        }
    }
}