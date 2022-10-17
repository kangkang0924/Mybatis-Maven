package com.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author 韩德康~
 * @version 1.0
 * @time 2022/09/05/10:34
 */
public class MybatisUtils {
    private static SqlSessionFactory sqlSessionFactory = null;
    static {
        //1.读取配置文件
        String resource = "mybatis-config.xml";
        //得到配置文件流
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            //2.根据配置文件信息，创建会话工厂
             sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            //3.通过工厂得到sqlsession
            SqlSession sqlSession = sqlSessionFactory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
            //throw new RuntimeException(e);
        }

    }

    public static SqlSession getSession() {
        return sqlSessionFactory.openSession();
    }
}
