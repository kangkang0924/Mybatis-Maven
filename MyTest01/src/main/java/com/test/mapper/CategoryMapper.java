package com.test.mapper;

import com.test.po.Category;

import java.util.Calendar;

/**
 * @author ���¿�~
 * @version 1.0
 * @time 2022/09/21/8:35
 */
public interface CategoryMapper {
   void addCategory(Category category);
   void updateCategory(Category category);
   Category findCategoryById(int id);
}
