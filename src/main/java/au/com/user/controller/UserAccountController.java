package au.com.user.controller;

import au.com.user.model.Account;
import au.com.user.model.AccountTransaction;
import au.com.user.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserAccountController {

    private List<Account> accounts = createAccounts();

    @Autowired
    public UserAccountService service;

    private static List<Account> createAccounts() {

        List<Account> accountList = new ArrayList<>();
        Account a1 = new Account();
                a1.accountNumber= "87778687";
                a1.name="chandana";

                Account a2 = new Account();
                a2.accountNumber="131212";
                a2.name="pingle";

                accountList.add(a1);
                accountList.add(a2);

        return accountList;
    }

    @RequestMapping(value = "/accounts", method = RequestMethod.GET, produces = "application/json")
    public List<Account> retrieveUserAccounts() {
        return service.getAccounts();
    }

    @RequestMapping(value = "/accountTransactions/{id}", method = RequestMethod.GET, produces = "application/json")
    public List<AccountTransaction> retrieveAccountTransactions(@PathVariable String id){
       return service.getAccountTransactions(id);
    }
}
