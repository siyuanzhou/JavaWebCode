package site.newvalue.service;

import site.newvalue.domain.Account;

import java.util.List;

public interface AccountService {
    public List<Account> findAll();
    void saveAccount(Account account);
}
