package com.mybatis.mapper;

import com.mybatis.pojo.IdCard;

/**
 * @author 韩德康~
 * @version 1.0
 * @time 2022/09/26/11:39
 */
public interface IdCardMapper {
    IdCard findIdCardById(int id);
}
