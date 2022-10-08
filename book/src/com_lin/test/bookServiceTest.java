package com_lin.test;

import com_lin.pojo.book;
import com_lin.pojo.page;
import com_lin.service.bookService;
import com_lin.service.impl.bookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class bookServiceTest {
    private bookService bookService = new bookServiceImpl();

    @Test
    public void addBook() {
        bookService.addBook(new book(null,"琳","lin",new BigDecimal(99.9),2000,200,null));
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(25);
    }

    @Test
    public void updateBook() {

    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(23));
    }

    @Test
    public void queryBooks() {
        for (book book : bookService.queryBooks()) {
            System.out.println(book);
        }
    }
    @Test
    public void page(){
        System.out.println(bookService.page(1, page.PAGE_SIZE));
    }

    @Test
    public void pageByPrice(){
        System.out.println(bookService.pageByPrice(1, com_lin.pojo.page.PAGE_SIZE,10,50));
    }
}