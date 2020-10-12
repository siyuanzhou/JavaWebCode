package site.syzhou.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import site.syzhou.dao.IAccountDao;
import site.syzhou.dao.IUserDao;
import site.syzhou.domain.User;


import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MybatisAnnoTest {
    private InputStream in;
    private SqlSession sqlSession;
    private IUserDao userDao;
    private IAccountDao accountDao;

    @Before
    public void init() throws IOException {
        //1.获取字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.根据输入流创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory= builder.build(in);
        //3.使用工厂生产SqlSession对象
        sqlSession =sqlSessionFactory.openSession();
        //4.使用SqlSession创建Dao接口的代理对象
        userDao =sqlSession.getMapper(IUserDao.class);
        accountDao=sqlSession.getMapper(IAccountDao.class);
    }

    @After
    public void destory() throws IOException {
        //提交
        sqlSession.commit();
        //6.释放资源
        sqlSession.close();
        in.close();
    }

    @Test
    public void testFindAll(){
        List<User> users =userDao.findAll();
        for(User user:users){
            System.out.println("-------一个用户的信息--------");
            System.out.println(user);
            System.out.println(user.getAccounts());
        }
    }
    @Test
    public void testfindById(){
        User user =userDao.findById(41);
        System.out.println(user);
    }
    @Test
    public void testInsertUser(){
        User user =new User();
        user.setUsername("insert user");
        user.setAddress("123");
        user.setBirthday(new Date());
        user.setSex("男");
        System.out.println(userDao.insertUser(user));
        System.out.println(user.getId());
    }
    @Test
    public void testUpdateUser(){
        User user =new User();
        user.setId(61);
        user.setUsername("update user");
        user.setAddress("123");
        user.setBirthday(new Date());
        user.setSex("男");
        System.out.println(userDao.updateUser(user));
    }
    @Test
    public void testDeleteUser(){
        userDao.deleteUser(60);
    }
    @Test
    public void testfindByName(){
        List<User> users =  userDao.findByName("%王%");
        System.out.println(users);
    }

}
