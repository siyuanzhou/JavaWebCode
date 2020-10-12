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
import site.syzhou.domain.AccountUser;
import site.syzhou.domain.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class AccountTest {
    private InputStream in=null;
    private  SqlSession session=null;
    private  IUserDao userDao;
    private IAccountDao accountDao;
    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3.使用工厂生产SqlSession对象
        session = factory.openSession();
        //4.使用SqlSession创建Dao接口的代理对象
        //userDao = session.getMapper(IUserDao.class);
        accountDao = session.getMapper(IAccountDao.class);
    }
    @Test
    public void testFindAll(){
        List<AccountUser> users=accountDao.findAll();
        for(AccountUser user : users){
            System.out.println(user);
        }
    }
    @Test
    public void testFindAllByFun2(){
        List<Account> users=accountDao.findAllByFun2();
        for(Account user : users){
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
