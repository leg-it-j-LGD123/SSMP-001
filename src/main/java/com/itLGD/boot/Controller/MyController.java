package com.itLGD.boot.Controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itLGD.boot.bean.Book;
import com.itLGD.boot.bean.R;
import com.itLGD.boot.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class MyController {
    @Autowired
    private IBookService bookService;
    @PostMapping
    public R save(@RequestBody Book book) {
      boolean flag =bookService.save(book);
        return new R(flag,flag?"添加成功！":"添加失败");
    }

    @PutMapping()
    public R update(@RequestBody Book book) {
        boolean flag=bookService.updateById(book);
        return new R(flag);
    }
    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id) {
        boolean flag=bookService.removeById(id);
        return new R(flag);
    }
    @GetMapping("{id}")
    public R getById(@PathVariable Integer id) {
        Book book=bookService.getById(id);
        return new R(true,book);
    }

    @GetMapping
    public R getAll() {
        List<Book> bookList=bookService.list();
        return new R(true,bookList);
    }

    @GetMapping("{current}/{size}")
    public R getPages(@PathVariable int current, @PathVariable int size,Book book) {
        IPage<Book> page=bookService.getPages(current,size,book);
        if(current>page.getPages()){
            page=bookService.getPages((int)page.getPages(),size,book);
        }
        return new R(true,page);
    }
}
