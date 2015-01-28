package cashew.service;

import cashew.entities.Account;
import cashew.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Created by Shipeng Xu on 25/1/15.
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;
    
    @Transactional(readOnly = true)
    public Account createAccount() {
        return new Account();
    }
    
    @Transactional
    public Account saveAccount(Account account) throws DataAccessException {
        return accountRepository.save(account);
    }

    @Transactional(readOnly = true)
    public Collection<Account> findAccounts() throws DataAccessException {
        return accountRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Account findAccountByEmail(String email) {
        return accountRepository.findByEmail(email);
    }
}
