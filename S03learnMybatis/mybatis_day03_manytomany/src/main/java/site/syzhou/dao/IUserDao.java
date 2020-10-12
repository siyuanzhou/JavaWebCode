package site.syzhou.dao;

import site.syzhou.domain.User;

import java.util.List;

public interface IUserDao {
    //查询所有用户和用户的账户信息
    public List<User> findAll();
}
