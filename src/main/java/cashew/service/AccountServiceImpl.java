package cashew.service;

import cashew.entities.Account;
import cashew.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.bind.DatatypeConverter;
import java.security.SecureRandom;
import java.util.Collection;

/**
 * Created by Shipeng Xu on 25/1/15.
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;
    
    @Autowired
    private CryptoService cryptoService;
    
    @Transactional(readOnly = true)
    public Account createAccount() {
        return new Account();
    }
    
    @Transactional
    public Account saveAccount(Account account) throws DataAccessException {
        SecureRandom sr;
        try {
            sr = SecureRandom.getInstance("SHA1PRNG", "SUN");
            byte[] randomBytes = new byte[64];
            sr.nextBytes(randomBytes);
            String saltString = DatatypeConverter.printHexBinary(randomBytes).toLowerCase();
            account.setSalt(saltString);

            String passwordHash = cryptoService.hashString(account.getPassword() + account.getSalt());
            account.setPassword(passwordHash);
            return accountRepository.save(account);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        
    }

    @Transactional(readOnly = true)
    public Collection<Account> findAccounts() throws DataAccessException {
        return accountRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Account findAccountByEmail(String email) {
        return accountRepository.findByEmail(email);
    }

    @Transactional(readOnly = true)
    public Account findAccountByNickname(String nickname) {
        return accountRepository.findByNickname(nickname);
    }
}
