package com.mybatis.mapper;

import com.mybatis.pojo.Functions;

/**
 * @author 韩德康~
 * @version 1.0
 * @time 2022/10/12/9:10
 */
public interface FunctionsMapper {
    Functions findFunctionsById(int id);
}
