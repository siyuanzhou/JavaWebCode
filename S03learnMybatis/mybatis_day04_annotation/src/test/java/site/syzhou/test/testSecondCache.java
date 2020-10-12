package site.syzhou.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import site.syzhou.dao.IUserDao;
import site.syzhou.domain.User;

import java.io.IOException;
import java.io.InputStream;

public class testSecondCache {
    public static void main(String[] args) throws IOException {
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory factory=builder.build(in);
        SqlSession sqlSession=factory.openSession();
        IUserDao userDao=sqlSession.getMapper(IUserDao.class);
        User user=userDao.findById(46);
        sqlSession.close();
        SqlSession sqlSession2=factory.openSession();
        User user2=sqlSession2.getMapper(IUserDao.class).findById(46);
        System.out.println(user==user2);
    }
}
