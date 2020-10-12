import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import site.newvalue.dao.AccountDao;
import site.newvalue.domain.Account;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMyBatis {
    @Test
    public void runTestMybatis() throws IOException {
        InputStream in= Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory factory=builder.build(in);
        //3.使用工厂生产SqlSession对象
        SqlSession sqlSession=factory.openSession();
        //4.使用SqlSession创建Dao接口的代理对象
        AccountDao accountDao=sqlSession.getMapper(AccountDao.class);
        accountDao.saveAccount(new Account("4",4.0));
        sqlSession.commit();
        List<Account> accounts=accountDao.findAll();
        for(Account account : accounts){
            System.out.println(account);
        }
        sqlSession.close();
    }
}