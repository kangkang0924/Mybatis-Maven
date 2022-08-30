package com.mybatis.test;

import java.io.IOException;


import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.testng.annotations.Test;

import com.mybatis.pojo.UserInfo;


public class MybatisTest {
    //根据id查询用户信息
    @Test
    public void findUserByIdTest() throws IOException {
        //1.读取配置文件
        String resource = "mybatis-config.xml";
        //得到配置文件流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //2.根据配置文件信息，创建会话工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //3.通过工厂得到sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //4.执行映射文件周的SQL，并返回映射结果
        UserInfo userinfo = sqlSession.selectOne("com.mybatis.mapper.UserInfoMapper.findUserInfoById", 1);
        //5.打印输出结果
        System.out.println(userinfo.toString());
        //6.关闭sqlsession
        sqlSession.close();
    }

    @Test
    public void findUserByNameTest() throws IOException {
        //1.读取配置文件
        String resource = "mybatis-config.xml";
        //得到配置文件流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //2.根据配置文件信息，创建会话工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //3.通过工厂得到sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<UserInfo> user =
                sqlSession.selectList("com.mybatis.mapper.UserInfoMapper.findUserInfoByName", "张");
        for (UserInfo userInfo : user) {
            System.out.println(userInfo);
        }
        //6.关闭sqlsession
        sqlSession.close();
    }

    @Test
    public void addUserInfoTest() throws IOException {
        //1.读取配置文件
        String resource = "mybatis-config.xml";
        //得到配置文件流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //2.根据配置文件信息，创建会话工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //3.通过工厂得到sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建User对象
        UserInfo user = new UserInfo();
        user.setUserName("李雷");
        user.setPassword("123");
        int rows = sqlSession.insert("com.mybatis.mapper.UserInfoMapper.addUserInfo", user);
        if (rows > 0) {
            System.out.println("插入了" + rows + "条数据");
        } else {
            System.out.println("插入失败");
        }
        //提交事务
        sqlSession.commit();
        //6.关闭sqlsession
        sqlSession.close();
    }
    @Test
    public void updateUserInfoTest() throws IOException {
        //1.读取配置文件
        String resource = "mybatis-config.xml";
        //得到配置文件流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //2.根据配置文件信息，创建会话工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //3.通过工厂得到sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();
       //加载编号为2的对象
        UserInfo user = sqlSession.selectOne("com.mybatis.mapper.UserInfoMapper.findUserInfoById",2);
        user.setPassword("789");
        int rows = sqlSession.update("com.mybatis.mapper.UserInfoMapper.updateUserInfo", user);

        if (rows > 0) {
            System.out.println("修改了" + rows + "条数据");
        } else {
            System.out.println("修改失败");
        }
        //提交事务
        sqlSession.commit();
        //6.关闭sqlsession
        sqlSession.close();
    }
    @Test
    public void deleteUserInfoTest() throws IOException {
        //1.读取配置文件
        String resource = "mybatis-config.xml";
        //得到配置文件流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //2.根据配置文件信息，创建会话工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //3.通过工厂得到sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();


        int rows = sqlSession.delete("com.mybatis.mapper.UserInfoMapper.deleteUserInfo", "7");

        if (rows > 0) {
            System.out.println("删除了" + rows + "条数据");
        } else {
            System.out.println("删除失败");
        }
        //提交事务
        sqlSession.commit();
        //6.关闭sqlsession
        sqlSession.close();
    }
}
