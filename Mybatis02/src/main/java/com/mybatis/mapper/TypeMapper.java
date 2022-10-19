package com.mybatis.mapper;


import com.mybatis.pojo.Type;

/**
 * @author 韩德康~
 * @version 1.0
 * @time 2022/10/03/11:15
 */
public interface TypeMapper {
    Type findTypeById(int id);

    void addType(Type type);

    void deleteTypeById(int id);
}
