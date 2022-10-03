package com.mybatis.mapper;

import com.mybatis.pojo.Person;

/**
 * @author 韩德康~
 * @version 1.0
 * @time 2022/09/26/11:37
 */
public interface PersonMapper {
    Person findPersonById(int id);
    Person findPersonById2(int id);
}
