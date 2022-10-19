package com.mybatis.mapper03;

import com.mybatis.pojo03.AdminInfo;

/**
 * @author 韩德康~
 * @version 1.0
 * @time 2022/10/12/8:43
 */
public interface AdminInfoMapper {
    AdminInfo findAdminInfoById(int id);
    AdminInfo findAdminInfoById2(int id);
}
