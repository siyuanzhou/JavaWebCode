package site.newvalue.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import site.newvalue.domain.Account;

import java.util.List;

@Repository
public interface AccountDao {
    @Select("select * from account")
    public List<Account> findAll();
    @Insert("insert into account(name,money) value(#{name},#{money})")
    public void saveAccount(Account account);
}
