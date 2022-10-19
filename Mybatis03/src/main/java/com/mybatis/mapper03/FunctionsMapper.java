package com.mybatis.mapper03;

import com.mybatis.pojo03.Functions;

import java.util.List;

/**
 * @author 韩德康~
 * @version 1.0
 * @time 2022/10/12/9:10
 */
public interface FunctionsMapper {
    List<Functions> findFunctionsById(int id);
}
