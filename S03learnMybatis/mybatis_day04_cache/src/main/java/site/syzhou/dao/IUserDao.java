package site.syzhou.dao;

import site.syzhou.domain.User;

import java.util.List;

public interface IUserDao {
    List<User> findAll();
}
