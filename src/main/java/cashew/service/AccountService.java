package cashew.service;

import cashew.entities.Account;
import org.springframework.dao.DataAccessException;

import java.util.Collection;

/**
 * Created by Shipeng Xu on 25/1/15.
 */
public interface AccountService {
    public Account createAccount();
    public Account saveAccount(Account account) throws DataAccessException;
    public Collection<Account> findAccounts() throws DataAccessException;
    public Account findAccountByEmail(String email);
    public Account findAccountByNickname(String nickname);
}
