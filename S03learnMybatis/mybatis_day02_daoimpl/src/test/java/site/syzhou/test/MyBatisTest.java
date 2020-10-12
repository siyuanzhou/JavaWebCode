package site.syzhou.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import site.syzhou.dao.IUserDao;
import site.syzhou.dao.impl.IUserDaoImpl;
import site.syzhou.domain.QueryVo;
import site.syzhou.domain.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MyBatisTest {
    private InputStream in=null;
    private  SqlSession session=null;
    private  IUserDao userDao;
    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3.使用工厂生产SqlSession对象
        session = factory.openSession();
        //4.使用SqlSession创建Dao接口的代理对象
        userDao=new IUserDaoImpl(session);
    }
    @Test
    public void testFindAll(){
        List<User> users=userDao.findAll();
        for(User user : users){
            System.out.println(user);
        }userDao.findAll();
    }
    @Test
    public void testSave(){
        User user = new User();
        user.setUsername("insert_User");
        user.setAddress("北京市顺义区");
        user.setSex("男");
        user.setBirthday(new Date());
        System.out.println("保存操作之前："+user);
        //5.执行保存方法
        userDao.saveUser(user);
        System.out.println("保存操作之后："+user);
    }
    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(42);
        user.setUsername("testUpdate");
        user.setAddress("北京市顺义区");
        user.setSex("男");
        user.setBirthday(new Date());
        System.out.println("更新操作之前："+user);
        //5.执行保存方法
        userDao.updateUser(user);
        System.out.println("更新操作之后："+user);
    }
    @Test
    public void testDeleteUser(){
        userDao.deleteUser(51);
    }
    @Test
    public void testFindByName(){
        List<User> users=userDao.findByName("%王%");
        for(User user:users){
            System.out.println(user);
        }
    }
    @Test
    public void testFindTotal(){
        System.out.println(userDao.findTotal());
    }
    @Test
    public void testFindByVo(){
        QueryVo vo=new QueryVo();
        User u =new User();
        u.setUsername("%王%");
        vo.setUser(u);
        List<User> users=userDao.findByName("%王%");
        for(User user:users){
            System.out.println(user);
        }
    }
    @After
    public void destory() throws IOException {
        //提交
        session.commit();
        //6.释放资源
        session.close();
        in.close();
    }
}
