package com.test.test;

import com.test.mapper.BookMapper;
import com.test.mapper.CategoryMapper;
import com.test.po.Book;
import com.test.po.Category;
import com.test.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;

/**
 * @author ���¿�~
 * @version 1.0
 * @time 2022/09/21/8:48
 */
public class MyBatisTest {
    @Test
    public void addCategoryTest() {
        String cname = "��ͯ����";
        String book_describe = "��ͯ����";
        Category category = new Category();
        category.setCname(cname);
        category.setDescribe(book_describe);

        //2. ��ȡSqlSession����
        SqlSession sqlSession = MybatisUtils.getSession();
        //3.��ȡMapper�ӿڵĴ������
        CategoryMapper categoryMapper = sqlSession.getMapper(CategoryMapper.class);
        //4.ִ�з���
        categoryMapper.addCategory(category);
        System.out.println("����ɹ�!");
        //�ύ����
        sqlSession.commit();
        //5.�ͷ���Դ
        sqlSession.close();

    }
    @Test
    public void updateCategoryTest() {
        String cname = "��ͯ����";
        String book_describe = "��ͯ����11111111";
        Category category = new Category();
        category.setCid(1);
        category.setCname(cname);
        category.setDescribe(book_describe);

        //2. ��ȡSqlSession����
        SqlSession sqlSession = MybatisUtils.getSession();
        //3.��ȡMapper�ӿڵĴ������
        CategoryMapper categoryMapper = sqlSession.getMapper(CategoryMapper.class);
        //4.ִ�з���
        categoryMapper.updateCategory(category);
        System.out.println("�޸ĳɹ�!");
        System.out.println(category.getCid());
        //�ύ����
        sqlSession.commit();
        //5.�ͷ���Դ
        sqlSession.close();

    }
    @Test
    public void findUserByIdTest() throws IOException {
        SqlSession sqlSession = MybatisUtils.getSession();

        //4.���ýӿ��еķ���ִ��sql
        CategoryMapper categoryMapper = sqlSession.getMapper(CategoryMapper.class);
        Category categoryById = categoryMapper.findCategoryById(1);

        //5.��ӡ������
        System.out.println(categoryById);
        //6.�ر�sqlsession
        sqlSession.close();
    }
    @Test
    public void addBookInfoTest() throws IOException {
        SqlSession sqlSession = MybatisUtils.getSession();

        //4.���ýӿ��еķ���ִ��sql
        CategoryMapper categoryMapper = sqlSession.getMapper(CategoryMapper.class);
        Category category = new Category();

        category.setCname("�������ͼ��");
        category.setDescribe("���,�������");
        categoryMapper.addCategory(category);

        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        Book book = new Book();
        book.setCategory(category);
        book.setIsbn("9787556097500");
        book.setBookName("Java�������");
        book.setAuthor("����");
        book.setPrice(39);
        book.setPress("��������ѧ������");
        bookMapper.addBookInfo(book);
        //5.��ӡ������
        System.out.println();
        //6.�ر�sqlsession
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void findCategoryByIdTest() throws IOException {
        SqlSession sqlSession = MybatisUtils.getSession();

        //4.���ýӿ��еķ���ִ��sql
        CategoryMapper categoryMapper = sqlSession.getMapper(CategoryMapper.class);
        Category categoryById = categoryMapper.findCategoryById(23);

        //5.��ӡ������
        System.out.println(categoryById);
        //6.�ر�sqlsession
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void findCategoryById2Test() throws IOException {
        SqlSession sqlSession = MybatisUtils.getSession();

        //4.���ýӿ��еķ���ִ��sql
        CategoryMapper categoryMapper = sqlSession.getMapper(CategoryMapper.class);
        Category categoryById = categoryMapper.findCategoryById2(23);

        //5.��ӡ������
        System.out.println(categoryById);
        //6.�ر�sqlsession
        sqlSession.commit();
        sqlSession.close();
    }
}
