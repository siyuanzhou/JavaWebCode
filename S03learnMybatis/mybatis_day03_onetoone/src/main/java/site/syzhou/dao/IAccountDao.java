package site.syzhou.dao;

import site.syzhou.domain.Account;
import site.syzhou.domain.AccountUser;

import javax.accessibility.AccessibleIcon;
import java.util.List;

public interface IAccountDao {
    //查询所有账户和账户下的用户信息
    public List<AccountUser> findAll();
    public List<Account> findAllByFun2();
}
