package com.test.po;

import lombok.Data;

import java.util.List;

/**
 * @author º«µÂ¿µ~
 * @version 1.0
 * @time 2022/09/21/8:23
 */
@Data
public class Category {
    private int cid;
    private String cname;
    private String describe;
    private List<Book> book;
}
