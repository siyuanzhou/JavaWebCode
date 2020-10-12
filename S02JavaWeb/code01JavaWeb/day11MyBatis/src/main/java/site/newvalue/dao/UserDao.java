package site.newvalue.dao;

import org.apache.ibatis.annotations.Select;
import site.newvalue.domain.User;

import java.util.List;

public interface UserDao {
    @Select("select * from user")
    List<User> findAll();
}
