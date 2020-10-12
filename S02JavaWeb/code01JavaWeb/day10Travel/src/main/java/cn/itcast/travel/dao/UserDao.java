package cn.itcast.travel.dao;

import cn.itcast.travel.domain.User;

public interface UserDao {
    void save(User user);
    User findByUsername(String username);
    User findByCode(String code);
    void updateStatus(User user);

    User findUsernameAndPassword(User user);
}
