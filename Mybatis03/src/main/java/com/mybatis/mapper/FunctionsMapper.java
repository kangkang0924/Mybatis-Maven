package com.mybatis.mapper;

import com.mybatis.pojo.Functions;

import java.util.List;

/**
 * @author 韩德康~
 * @version 1.0
 * @time 2022/10/12/9:10
 */
public interface FunctionsMapper {
    List<Functions> findFunctionsById(int id);
}
