package com.itLGD.boot.test;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itLGD.boot.Dao.bookDao;
import com.itLGD.boot.bean.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestDao {
    @Autowired
    private bookDao bookdao;
    @Test
    void testGetById(){
        System.out.println(bookdao.selectById(1));
    }
    @Test
    void testSave(){
        Book book=new Book();
        book.setType("111");
        book.setDescription("111");
        book.setName("111");
        bookdao.insert(book);
    }
    @Test
    void testUpdata(){
        Book book=new Book();
        book.setId(13);
        book.setType("112");
        book.setDescription("111");
        book.setName("111");
        bookdao.updateById(book);
    }
    @Test
    void testDeleteById(){
      bookdao.deleteById(13);
    }
    @Test
    void GetAllTest(){
        bookdao.selectList(null);
    }
    @Test
    void TestPages(){
        IPage page=new Page(2,5);
        bookdao.selectPage(page,null);
        System.out.println(page.getCurrent() );
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getPages());
        System.out.println(page.getRecords());
    }
    @Test
    void testById(){
        QueryWrapper<Book> queryWrapper=new QueryWrapper<>();
        queryWrapper.like("name","Spring");
        bookdao.selectList(queryWrapper);
    }
    @Test
    void testById2(){
        String name="Spring";
        LambdaQueryWrapper<Book> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.like(name!=null,Book::getName,name);
        bookdao.selectList(queryWrapper);
    }
}
