package com.mybatis.mapper03;

import com.mybatis.pojo03.Type;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * @author 韩德康~
 * @version 1.0
 * @time 2022/10/03/11:15
 */
public interface TypeMapper {
    @Select("select *\n" +
            "        from type\n" +
            "        where id = #{id}")
//    @Results({
//            @Result(id = true,column = "id", property = "id"),
//            @Result(column = "name", property = "name"),
//            @Result(column = "id", property = "pis",many = @Many(select = "com.mybatis.mapper03.ProductInfoMapper.finProductInfoById"))
//    })
    Type findTypeById(int id);

    void addType(Type type);

    void deleteTypeById(int id);
}
