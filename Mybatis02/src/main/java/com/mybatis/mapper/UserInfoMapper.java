package com.mybatis.mapper;

import com.mybatis.pojo.UserInfo;

import java.util.List;

/**
 * @author 韩德康~
 * @version 1.0
 */
public interface UserInfoMapper {
    /**
     * 1.接口中的方法名和mapper.xml（映射文件）中的标签的id值相同
     * 2.方法中的输入参数mapper.xml文件中标签的parameterType类型一致
     * 3.方法的返回值和mapper.xml文件标签的resultType一致
     * 映射文件中的namespace的值就是接口的全类名（接口）
     */
    UserInfo findUserInfoById(int id);
    List<UserInfo> findUserInfoByName(String name);
    /**
     *
     */
    int addUserInfo(UserInfo userInfo);
    int updateUserInfo (UserInfo userInfo);
    int deleteUserInfo (int id);
}
