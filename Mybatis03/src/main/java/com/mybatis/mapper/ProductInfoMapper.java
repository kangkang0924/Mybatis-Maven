package com.mybatis.mapper;

import com.mybatis.pojo.ProductInfo;

/**
 * @author 韩德康~
 * @version 1.0
 * @time 2022/10/03/11:26
 */
public interface ProductInfoMapper {
    ProductInfo finProductInfoById (int id);
    void addProductInfo(ProductInfo pi);
}
