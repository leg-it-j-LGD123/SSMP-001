package com.itLGD.boot.test;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itLGD.boot.bean.Book;
import com.itLGD.boot.service.BookService;
import com.itLGD.boot.service.IBookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestService {
    @Autowired
    private BookService bookService; @Test
    void testGetById(){
        System.out.println(bookService.getById(1));
    }
    @Test
    void testSave(){
        Book book=new Book();
        book.setType("111");
        book.setDescription("111");
        book.setName("111");
        System.out.println(bookService.save(book));
    }
    @Test
    void testUpdata(){
        Book book=new Book();
        book.setId(24);
        book.setType("112");
        book.setDescription("111");
        book.setName("111");
        System.out.println(bookService.update(book));
    }
    @Test
    void testDeleteById(){
        System.out.println(bookService.delete(14));
    }
    @Test
    void GetAllTest(){
        System.out.println(bookService.getAll());
    }
    @Test
    void TestPages(){
        System.out.println(bookService.getPages(2,5));

    }
    @Autowired
    private IBookService iBookService;
    @Test
    void Test(){
        Book book=new Book();
        book.setId(24);
        book.setType("113");
        book.setDescription("111");
        book.setName("111");
     iBookService.updateById(book);
    }
//    @Test
//    void testById(){
//        QueryWrapper<Book> queryWrapper=new QueryWrapper<>();
//        queryWrapper.like("name","Spring");
//        bookdao.selectList(queryWrapper);
//    }
//    @Test
//    void testById2(){
//        String name="Spring";
//        LambdaQueryWrapper<Book> queryWrapper=new LambdaQueryWrapper<>();
//        queryWrapper.like(name!=null,Book::getName,name);
//        bookdao.selectList(queryWrapper);
//    }
}
