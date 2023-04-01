package com.itLGD.boot.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itLGD.boot.bean.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface bookDao extends BaseMapper<Book> {
}
