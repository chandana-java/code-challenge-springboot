package au.com.user.service;

import au.com.user.model.Account;
import au.com.user.model.AccountTransaction;
import au.com.user.repository.AccountDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAccountService {

    @Autowired
    public AccountDAO accountDao;

    public List<Account> getAccounts(){
        return accountDao.retrieveAccounts();
    }

    public List<AccountTransaction> getAccountTransactions(String accountNumber){
        return accountDao.retrieveTansactionsByAccount(accountNumber);
    }

}
