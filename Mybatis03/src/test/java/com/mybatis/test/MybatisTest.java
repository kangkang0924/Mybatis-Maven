package com.mybatis.test;

import com.mybatis.mapper.*;
import com.mybatis.pojo.*;
import com.mybatis.utils.MybatisUtils;

import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;


public class MybatisTest {
    //根据id查询用户信息
    @Test
    public void findUserByIdTest() throws IOException {
        //1.读取配置文件
        //String resource = "mybatis-config.xml";
        //得到配置文件流
        //InputStream inputStream = Resources.getResourceAsStream(resource);
        //2.根据配置文件信息，创建会话工厂
        //SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //3.通过工厂得到sqlsession
        //SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession = MybatisUtils.getSession();
        //4.执行映射文件周的SQL，并返回映射结果
        //UserInfo userinfo = sqlSession.selectOne("com.mybatis.mapper.UserInfoMapper.findUserInfoById", 1);

        //4.调用接口中的方法执行sql
        UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
        UserInfo userInfoById = userInfoMapper.findUserInfoById(2);

        //5.打印输出结果
        System.out.println(userInfoById.toString());
        //6.关闭sqlsession
        sqlSession.close();
    }

    @Test
    public void findUserByNameTest() {
        //1.读取配置文件
        //String resource = "mybatis-config.xml";
        //得到配置文件流
        //InputStream inputStream = Resources.getResourceAsStream(resource);
        //2.根据配置文件信息，创建会话工厂
        //SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //3.通过工厂得到sqlsession
        //SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession = MybatisUtils.getSession();

//        List<UserInfo> user =
//                sqlSession.selectList("com.mybatis.mapper.UserInfoMapper.findUserInfoByName", "张");
        UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
        List<UserInfo> userInfoByName = userInfoMapper.findUserInfoByName("张三");
        for (UserInfo userInfo : userInfoByName) {
            System.out.println(userInfo);
        }
        //6.关闭sqlsession
        sqlSession.close();
    }

    @Test
    public void addUserInfoTest() throws IOException {
        //1.读取配置文件
        //String resource = "mybatis-config.xml";
        //得到配置文件流
        //InputStream inputStream = Resources.getResourceAsStream(resource);
        //2.根据配置文件信息，创建会话工厂
        //SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //3.通过工厂得到sqlsession
        //SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession = MybatisUtils.getSession();

        //创建User对象

        UserInfo user = new UserInfo();
        user.setUserName("李雷");
        user.setPassword("123");
//        int rows = sqlSession.insert("com.mybatis.mapper.UserInfoMapper.addUserInfo", user);
//        if (rows > 0) {
//            System.out.println("插入了" + rows + "条数据");
//        } else {
//            System.out.println("插入失败");
//        }
        UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
        userInfoMapper.addUserInfo(user);
        System.out.println("插入成功");
        System.out.println(user.getId());
        //提交事务
        sqlSession.commit();
        //6.关闭sqlsession
        sqlSession.close();
    }

    @Test
    public void updateUserInfoTest() throws IOException {
        //1.读取配置文件
        //String resource = "mybatis-config.xml";
        //得到配置文件流
        //InputStream inputStream = Resources.getResourceAsStream(resource);
        //2.根据配置文件信息，创建会话工厂
        //SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //3.通过工厂得到sqlsession
        //SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession = MybatisUtils.getSession();
        //加载编号为2的对象

        //UserInfo user = sqlSession.selectOne("com.mybatis.mapper.UserInfoMapper.findUserInfoById", 2);
        UserInfoMapper usermapper = sqlSession.getMapper(UserInfoMapper.class);
        UserInfo user = usermapper.findUserInfoById(2);
        user.setPassword("123654");
        usermapper.updateUserInfo(user);
        System.out.println("i");
//        int rows = sqlSession.update("com.mybatis.mapper.UserInfoMapper.updateUserInfo", user);
//
//        if (rows > 0) {
//            System.out.println("修改了" + rows + "条数据");
//        } else {
//            System.out.println("修改失败");
//        }
        //提交事务
        sqlSession.commit();
        //6.关闭sqlsession
        sqlSession.close();
    }

    @Test
    public void deleteUserInfoTest() throws IOException {
        //1.读取配置文件
        //String resource = "mybatis-config.xml";
        //得到配置文件流
        //InputStream inputStream = Resources.getResourceAsStream(resource);
        //2.根据配置文件信息，创建会话工厂
        //SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //3.通过工厂得到sqlsession
        //SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession = MybatisUtils.getSession();
        //MybatisUtils mybatisUtils = new MybatisUtils();

        UserInfoMapper usermapper = sqlSession.getMapper(UserInfoMapper.class);
        usermapper.deleteUserInfo(23);
//        int rows = sqlSession.delete("com.mybatis.mapper.UserInfoMapper.deleteUserInfo", "7");
//
//        if (rows > 0) {
//            System.out.println("删除了" + rows + "条数据");
//        } else {
//            System.out.println("删除失败");
//        }
        //提交事务
        sqlSession.commit();
        //6.关闭sqlsession
        sqlSession.close();
    }
    @Test
    public void findUserInfoByNameAndXexTest() throws IOException {
        //1.读取配置文件
        //String resource = "mybatis-config.xml";
        //得到配置文件流
        //InputStream inputStream = Resources.getResourceAsStream(resource);
        //2.根据配置文件信息，创建会话工厂
        //SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //3.通过工厂得到sqlsession
        //SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession = MybatisUtils.getSession();

//        List<UserInfo> user =
//                sqlSession.selectList("com.mybatis.mapper.UserInfoMapper.findUserInfoByName", "张");
        UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
        UserInfo user = new UserInfo();
        user.setUserName("张三");
        user.setSex("1");
        List<UserInfo> userInfoByName = userInfoMapper.findUserInfoByNameAndXex(user);
        for (UserInfo userInfo : userInfoByName) {
            System.out.println(userInfo);
        }
        //6.关闭sqlsession
        sqlSession.close();
    }
    @Test
    public void findUserInfoByNameandSexWithIfTest() throws IOException {
        //1.读取配置文件
        //String resource = "mybatis-config.xml";
        //得到配置文件流
        //InputStream inputStream = Resources.getResourceAsStream(resource);
        //2.根据配置文件信息，创建会话工厂
        //SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //3.通过工厂得到sqlsession
        //SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession = MybatisUtils.getSession();

//        List<UserInfo> user =
//                sqlSession.selectList("com.mybatis.mapper.UserInfoMapper.findUserInfoByName", "张");
        UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
        UserInfo user = new UserInfo();
        user.setUserName("张三");
        user.setSex("1");
        List<UserInfo> userInfos = userInfoMapper.findUserInfoByNameandSexWithIf(user);
        for (UserInfo userInfo : userInfos) {
            System.out.println(userInfo);
        }
        //6.关闭sqlsession
        sqlSession.close();
    }
    @Test
    public void findUserInfo_ChooseTest() throws IOException {
        //1.读取配置文件
        //String resource = "mybatis-config.xml";
        //得到配置文件流
        //InputStream inputStream = Resources.getResourceAsStream(resource);
        //2.根据配置文件信息，创建会话工厂
        //SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //3.通过工厂得到sqlsession
        //SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession = MybatisUtils.getSession();

//        List<UserInfo> user =
//                sqlSession.selectList("com.mybatis.mapper.UserInfoMapper.findUserInfoByName", "张");
        UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
        UserInfo user = new UserInfo();
        user.setUserName("张三");
        user.setSex("1");
        user.setEmail("123@com");
        List<UserInfo> userInfos = userInfoMapper.findUserInfo_Choose(user);
        for (UserInfo userInfo : userInfos) {
            System.out.println(userInfo);
        }
        //6.关闭sqlsession
        sqlSession.close();
    }
    @Test
    public void updateUserInfoWithSetTest() throws IOException {
        SqlSession sqlsession = MybatisUtils.getSession();
        //加载编号为2的对象
        //      UserInfo user=sqlsession.selectOne("com.mybatis.mapper.UserInfoMapper.findUserInfoById",2);
        UserInfo user = new UserInfo();
        user.setId(2);
        user.setUserName("张三");
        user.setPassword("789");
//        int rows = sqlsession.update("com.mybatis.mapper.UserInfoMapper.updateUserInfo",user);
        /*if(rows>0){
            System.out.println("修改了"+ rows + "条数据");
        }else{
            System.out.println("修改失败");
        }*/
        UserInfoMapper usermapper = sqlsession.getMapper(UserInfoMapper.class);
        usermapper.updateUserInfoWithSet(user);
        System.out.println("更新成功");
        //提交事务
        sqlsession.commit();
        //6.关闭sqlsession
        sqlsession.close();
    }

    @Test
    public void findPersonByIdTest() throws IOException {

        SqlSession sqlSession = MybatisUtils.getSession();

        PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
        Person person = personMapper.findPersonById(1);
        System.out.println("person = " + person);
        //6.关闭sqlsession
        sqlSession.close();
    }
    @Test
    public void findPersonById2Test() {

        SqlSession sqlSession = MybatisUtils.getSession();

        PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
        Person person = personMapper.findPersonById2(1);
        System.out.println("person = " + person);
        //6.关闭sqlsession
        sqlSession.close();
    }
    @Test
    public void findTypeIdTest() {

        SqlSession sqlSession = MybatisUtils.getSession();

        TypeMapper TypeMapper = sqlSession.getMapper(TypeMapper.class);
        Type type = TypeMapper.findTypeById(1);
        System.out.println(type);
        //6.关闭sqlsession
        sqlSession.close();
    }
    @Test
    public void addTypeTest(){
        SqlSession sqlSession = MybatisUtils.getSession();
        TypeMapper typeMapper = sqlSession.getMapper(TypeMapper.class);
        Type type = new Type();
        type.setName("打印机");
        typeMapper.addType(type);

        ProductInfo p1 = new ProductInfo();
        ProductInfo p2 = new ProductInfo();
        p1.setCode("1111");
        p1.setName("HP1306");
        p2.setCode("2222");
        p2.setName("HP11103");
        p1.setType(type);
        p2.setType(type);
        ProductInfoMapper productInfoMapper = sqlSession.getMapper(ProductInfoMapper.class);
        productInfoMapper.addProductInfo(p1);
        productInfoMapper.addProductInfo(p2);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void deleteTypeByIdTest(){
        int id = 3;
        SqlSession sqlSession = MybatisUtils.getSession();
        TypeMapper typeMapper = sqlSession.getMapper(TypeMapper.class);
        typeMapper.deleteTypeById(id);

        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void findAdminInfoByIdTest() throws IOException{
        int id = 1;
        SqlSession sqlSession = MybatisUtils.getSession();
        AdminInfoMapper adminInfoMapper = sqlSession.getMapper(AdminInfoMapper.class);
        AdminInfo adminInfo = adminInfoMapper.findAdminInfoById(id);
        System.out.println(adminInfo);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void findAdminInfoByIdTest2() throws IOException{
        int id = 1;
        SqlSession sqlSession = MybatisUtils.getSession();
        AdminInfoMapper adminInfoMapper = sqlSession.getMapper(AdminInfoMapper.class);
        AdminInfo adminInfo = adminInfoMapper.findAdminInfoById2(id);
        System.out.println(adminInfo);
        sqlSession.commit();
        sqlSession.close();
    }
}
