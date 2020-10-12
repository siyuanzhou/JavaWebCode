package site.syzhou.dao;

import org.apache.ibatis.annotations.Select;
import site.syzhou.domain.User;

import java.util.List;

public interface IUserDao {
    @Select("select * from user")
    List<User> findAll();
}
