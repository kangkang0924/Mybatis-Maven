package com.mybatis.mapper03;

import com.mybatis.pojo03.ProductInfo;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * @author 韩德康~
 * @version 1.0
 * @time 2022/10/03/11:26
 */
public interface ProductInfoMapper {
    @Select("select * from product_info where tid = #{id}")
    ProductInfo finProductInfoById (int id);

    @Select("select * from product_info where id = #{id}")
    @Results({
            @Result(column = "tid", property = "type", one = @One(select = "com.mybatis.mapper03.TypeMapper.findTypeById"))
    })
    ProductInfo finProductInfoById2 (int id);

    void addProductInfo(ProductInfo pi);
}
