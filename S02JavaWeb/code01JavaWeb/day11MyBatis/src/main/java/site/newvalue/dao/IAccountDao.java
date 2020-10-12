package site.newvalue.dao;

import site.newvalue.domain.AccountUser;

import java.util.List;

public interface IAccountDao {
    //查询所有账户，同时获取账户的所属用户名称以及它的地址信息
    List<AccountUser> findAll();
}
