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
import site.syzhou.domain.Account;
import site.syzhou.domain.User;


import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class AccountTest {
    private InputStream in;
    private SqlSession sqlSession;
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
        List<Account> accounts =accountDao.findAll();
        for(Account account:accounts){
            System.out.println("-------一个账户的信息------");
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }


}
