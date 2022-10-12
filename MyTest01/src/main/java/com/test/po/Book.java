package com.test.po;

import lombok.Data;

/**
 * @author º«µÂ¿µ~
 * @version 1.0
 * @time 2022/10/12/13:32
 */
@Data
public class Book {
    private int id;
    private String isbn;
    private String bookName;
    private String author;
    private double price;
    private String press;
    private int typeId;
    private Category category;

}
