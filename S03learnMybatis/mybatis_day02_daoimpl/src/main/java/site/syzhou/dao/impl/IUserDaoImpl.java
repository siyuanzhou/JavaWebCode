package site.syzhou.dao.impl;

import org.apache.ibatis.session.SqlSession;
import site.syzhou.domain.User;

import java.util.List;

public class IUserDaoImpl implements site.syzhou.dao.IUserDao {
    private SqlSession session;
    
    public IUserDaoImpl(SqlSession session){
        this.session=session;
    }

    public List<User> findAll() {
        List<User> users=session.selectList("site.syzhou.dao.IUserDao.findAll");
        return users;
    }

    public int saveUser(User user) {
        int id=session.insert("site.syzhou.dao.IUserDao.saveUser",user);
        session.commit();
        session.close();
        return id;
    }

    public int updateUser(User user) {
        int id=session.update("site.syzhou.dao.IUserDao.updateUser",user);
        session.commit();
        session.close();
        return id;
    }

    public int deleteUser(int uid) {
        int id=session.update("site.syzhou.dao.IUserDao.deleteUser",uid);
        session.commit();
        session.close();
        return id;
    }

    public List<User> findByName(String name) {
        List<User> users=session.selectList("site.syzhou.dao.IUserDao.findByName",name);
        return users;
    }

    public int findTotal() {
        int ans=session.selectOne("site.syzhou.dao.IUserDao.findTotal");
        return ans;
    }

}
