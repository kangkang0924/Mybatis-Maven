package com.test.test;

import com.test.mapper.CategoryMapper;
import com.test.po.Category;
import com.test.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;

/**
 * @author 韩德康~
 * @version 1.0
 * @time 2022/09/21/8:48
 */
public class MyBatisTest {
    @Test
    public void addCategoryTest() {
        String cname = "儿童丛书";
        String book_describe = "儿童读物";
        Category category = new Category();
        category.setCname(cname);
        category.setDescribe(book_describe);

        //2. 获取SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSession();
        //3.获取Mapper接口的代理对象
        CategoryMapper categoryMapper = sqlSession.getMapper(CategoryMapper.class);
        //4.执行方法
        categoryMapper.addCategory(category);
        System.out.println("插入成功!");
        //提交事务
        sqlSession.commit();
        //5.释放资源
        sqlSession.close();

    }
    @Test
    public void updateCategoryTest() {
        String cname = "儿童丛书";
        String book_describe = "儿童读物11111111";
        Category category = new Category();
        category.setCid(1);
        category.setCname(cname);
        category.setDescribe(book_describe);

        //2. 获取SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSession();
        //3.获取Mapper接口的代理对象
        CategoryMapper categoryMapper = sqlSession.getMapper(CategoryMapper.class);
        //4.执行方法
        categoryMapper.updateCategory(category);
        System.out.println("修改成功!");
        System.out.println(category.getCid());
        //提交事务
        sqlSession.commit();
        //5.释放资源
        sqlSession.close();

    }
    @Test
    public void findUserByIdTest() throws IOException {
        SqlSession sqlSession = MybatisUtils.getSession();

        //4.调用接口中的方法执行sql
        CategoryMapper categoryMapper = sqlSession.getMapper(CategoryMapper.class);
        Category categoryById = categoryMapper.findCategoryById(1);

        //5.打印输出结果
        System.out.println(categoryById);
        //6.关闭sqlsession
        sqlSession.close();
    }
}
