package au.com.user.repository;

import au.com.user.model.Account;
import au.com.user.model.AccountTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class AccountDAO extends JdbcDaoSupport {

    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize(){
        setDataSource(dataSource);
    }


    public List<Account> retrieveAccounts(){
        String sql ="select * from account";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

        List<Account> result = new ArrayList<Account>();
        for(Map<String, Object> row:rows){
            Account acc = new Account();
            acc.accountNumber = ((String)row.get("accountNumber"));
            acc.name = ((String)row.get("accountName"));
            acc.currency = ((String)row.get("currency"));
            acc.balance = ((BigDecimal)row.get("balance"));
            acc.balanceDate = new Date(((Timestamp)row.get("balanceDate")).getTime());
            acc.type = ((String)row.get("type"));
            result.add(acc);
        }

        return result;


    }

    public List<AccountTransaction> retrieveTansactionsByAccount(String accountNumber){
        String sql ="select * from accountTransaction where accountNumber = "+accountNumber;
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

        List<AccountTransaction> result = new ArrayList<AccountTransaction>();
        for(Map<String, Object> row:rows){
            AccountTransaction tx = new AccountTransaction();
            tx.accountNumber = ((String)row.get("accountNumber"));
            tx.accountName = ((String)row.get("accountName"));
            tx.currency = ((String)row.get("currency"));
            tx.debitAmount = ((BigDecimal)row.get("debitAmount"));
            tx.creditAmount = ((BigDecimal)row.get("creditAmount"));
            tx.type = ((String)row.get("type"));
            result.add(tx);
        }

        return result;

    }



}
