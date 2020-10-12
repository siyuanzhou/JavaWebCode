package site.syzhou.dao;

import site.syzhou.domain.QueryVo;
import site.syzhou.domain.User;

import java.util.List;

public interface IUserDao {
    //查找全部
    List<User> findAll();
    //保存操作
    int saveUser(User user);
    //更新操作
    int updateUser(User user);
    //删除操作
    int deleteUser(int id);
    //模糊查找
    List<User> findByName(String name);
    //聚合查詢
    int findTotal();
}
