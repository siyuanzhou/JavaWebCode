package site.newvalue.dao;

import site.newvalue.domain.QueryVo;
import site.newvalue.domain.QueryVo2;
import site.newvalue.domain.User;

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
    //根据VO条件查找用户
    List<User> findByVo(QueryVo vo);
    //根据用户信息，查询用户列表
    List<User> findByUser(User user);
    //根据 id 集合查询用户
    List<User> findInIds(QueryVo2 vo);
}