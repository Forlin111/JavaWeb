package com_lin.service.impl;

import com_lin.dao.bookDao;
import com_lin.dao.impl.bookDaoImpl;
import com_lin.pojo.book;
import com_lin.pojo.page;
import com_lin.service.bookService;

import java.util.List;

public class bookServiceImpl implements bookService {
    private bookDao bookDao = new bookDaoImpl();


    @Override
    public void addBook(book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookDao.deleteBookById(id);
    }

    @Override
    public void updateBook(book book) {
        bookDao.updateBook(book);
    }

    @Override
    public book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<book> queryBooks() {
        return bookDao.queryBooks();
    }

    @Override
    public page<book> page(int pageNo, int pageSize) {
        page<book> page = new page<>();
        if (pageNo < 1) {
            pageNo = 1;
        }
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        Integer pageTotalCount = bookDao.queryForPageTotalCount();
        page.setPageTotalCount(pageTotalCount);
        //求总页码
        Integer pageTotal = pageTotalCount % pageSize > 0 ? pageTotalCount / pageSize + 1 : pageTotalCount / pageSize;

//        // 求总页码
//        Integer pageTotal = pageTotalCount / pageSize;
//        if (pageTotalCount % pageSize > 0) {
//            pageTotal+=1;
//        }
        page.setPageTotal(pageTotal);

        if (pageNo > pageTotal) {
            pageNo = pageTotal;
        }
        //设置当前页数据
        int begin = (pageNo - 1) * page.getPageSize();
        List<book> items = bookDao.queryForPageItems(begin, pageSize);
        page.setItems(items);
        return page;
    }

    @Override
    public page<book> pageByPrice(int pageNo, int pageSize, int min, int max) {
        page<book> page = new page<>();
        if (pageNo < 1) {
            pageNo = 1;
        }
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        Integer pageTotalCount = bookDao.queryForPageTotalCountByPrice(min,max);
        page.setPageTotalCount(pageTotalCount);
        //求总页码
        Integer pageTotal = pageTotalCount % pageSize > 0 ? pageTotalCount / pageSize + 1 : pageTotalCount / pageSize;
        page.setPageTotal(pageTotal);

        if (pageNo > pageTotal) {
            pageNo = pageTotal;
        }
        //设置当前页数据
        int begin = (pageNo - 1) * page.getPageSize();
        List<book> items = bookDao.queryForPageItemsByPrice(begin, pageSize,min,max);
        page.setItems(items);
        return page;
    }
}
