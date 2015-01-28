package cashew.repository;

import cashew.entities.Account;
import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.Repository;

import java.util.Collection;

/**
 * Created by Shipeng Xu on 25/1/15.
 */
public interface AccountRepository extends Repository<Account, Long> {
    Account save(Account account) throws DataAccessException;
    Collection<Account> findAll() throws DataAccessException;
    Account findByEmail(String email) throws DataAccessException;
}
