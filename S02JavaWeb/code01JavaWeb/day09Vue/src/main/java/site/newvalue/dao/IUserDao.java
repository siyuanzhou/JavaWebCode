package site.newvalue.dao;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import site.newvalue.domain.User;

import java.util.List;

public interface IUserDao {
    @Select("select * from user")
    public List<User> findAll();
    @Select("select * from user where id=#{id}")
    User findById(Integer id);
    @Update("update user set username=#{username},password=#{password},sex=#{sex},age=#{age},email=#{email} where id=#{id}")
    void update(User user);
}