package com.itLGD.boot.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.itLGD.boot.Dao.bookDao;
import com.itLGD.boot.bean.Book;

public interface IBookService extends IService<Book>{
    IPage<Book> getPages(int current,int size,Book book);
}
