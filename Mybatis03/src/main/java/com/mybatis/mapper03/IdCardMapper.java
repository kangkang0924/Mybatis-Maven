package com.mybatis.mapper03;

import com.mybatis.pojo03.IdCard;
import org.apache.ibatis.annotations.Select;

/**
 * @author 韩德康~
 * @version 1.0
 * @time 2022/09/26/11:39
 */
public interface IdCardMapper {
    @Select("select * from idcard where id = #{id}")
    IdCard findIdCardById(int id);
}
