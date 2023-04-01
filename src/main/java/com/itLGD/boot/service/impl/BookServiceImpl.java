package com.itLGD.boot.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itLGD.boot.Dao.bookDao;
import com.itLGD.boot.bean.Book;
import com.itLGD.boot.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private bookDao bookdao;
    @Override
    public boolean save(Book book) {
        return bookdao.insert(book)>0;
    }

    @Override
    public boolean update(Book book) {

        return bookdao.updateById(book)>0;
    }

    @Override
    public boolean delete(Integer id) {
        return bookdao.deleteById(id)>0;
    }

    @Override
    public Book getById(Integer id) {
        return bookdao.selectById(id);
    }

    @Override
    public List<Book> getAll() {
        return bookdao.selectList(null);
    }

    @Override
    public IPage<Book> getPages(int current, int size) {
        IPage<Book> page = new Page<>(current,size);
        bookdao.selectPage(page,null);
        return page;
    }
}
