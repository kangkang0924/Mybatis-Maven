package com.mybatis.mapper03;

import com.mybatis.pojo03.Person;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * @author 韩德康~
 * @version 1.0
 * @time 2022/09/26/11:37
 */
public interface PersonMapper {
    @Select(" select *\n" +
            "        from Person\n" +
            "        where id = #{id}")
    @Results({
            @Result(column = "cid", property = "idCard", one = @One(select = "com.mybatis.mapper03.IdCardMapper.findIdCardById"))
    })
    Person findPersonById(int id);
    Person findPersonById2(int id);
}
