package com.itLGD.boot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itLGD.boot.Dao.bookDao;
import com.itLGD.boot.service.BookService;
import com.itLGD.boot.service.IBookService;
import com.itLGD.boot.bean.Book;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IBookServiceImpl extends ServiceImpl<bookDao, Book> implements IBookService{
    @Autowired
    private bookDao bookdao;
    public IPage<Book> getPages(int current, int size,Book book) {
        LambdaQueryWrapper<Book> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.like(Strings.isNotEmpty(book.getName()),Book::getName,book.getName());
        queryWrapper.like(Strings.isNotEmpty(book.getDescription()),Book::getDescription,book.getDescription());
        queryWrapper.like(Strings.isNotEmpty(book.getType()), Book::getType, book.getType());
        IPage<Book> page = new Page<>(current,size);
        bookdao.selectPage(page,queryWrapper);
        return page;
    }

}
