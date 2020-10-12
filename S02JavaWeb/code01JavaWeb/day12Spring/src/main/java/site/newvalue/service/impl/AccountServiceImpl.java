package site.newvalue.service.impl;

import site.newvalue.dao.IAccountDao;
import site.newvalue.dao.impl.AccountDaoImpl;
import site.newvalue.service.IAccountService;

public class AccountServiceImpl implements IAccountService {
    IAccountDao accountDao=new AccountDaoImpl();
    @Override
    public void saveAccount() {
        accountDao.saveAccount();
    }
}
