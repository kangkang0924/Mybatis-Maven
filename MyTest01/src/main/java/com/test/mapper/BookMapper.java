package com.test.mapper;

import com.test.po.Book;

/**
 * @author ���¿�~
 * @version 1.0
 * @time 2022/10/12/13:49
 */
public interface BookMapper {
    void addBookInfo(Book book);
    Book findBookById(int id);
}
