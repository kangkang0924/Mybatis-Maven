package com.mybatis.mapper03;

import com.mybatis.pojo03.UserInfo;
import org.apache.ibatis.annotations.*;

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
    @Select("select * from user_info where id = #{id}")
    @Results(id = "userMap", value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "userName", property = "userName"),
            @Result(column = "password", property = "password")
    })
    UserInfo findUserInfoById(int id);

    @Select("select *\n" +
            "        from user_info\n" +
            "        where userName like '%' + #{search_name} + '%'")
    @ResultMap(value = "userMap")
    List<UserInfo> findUserInfoByName(String name);

    /**
     *
     */
    @Insert("insert into user_info(userName, password)\n" +
            "        values (#{userName}, #{password})")
    void addUserInfo(UserInfo userInfo);

    @Update(" update user_info\n" +
            "        set userName = #{userName},\n" +
            "            password = #{password}\n" +
            "        where id = #{id}")
    void updateUserInfo(UserInfo userInfo);

    @Delete(" delete\n" +
            "        from user_info\n" +
            "        where id = #{id}")
    void deleteUserInfo(int id);

    List<UserInfo> findUserInfoByNameAndXex(UserInfo userInfo);

    List<UserInfo> findUserInfoByNameandSexWithIf(UserInfo userInfo);

    List<UserInfo> findUserInfo_Choose(UserInfo userInfo);

    void updateUserInfoWithSet(UserInfo user);
}
