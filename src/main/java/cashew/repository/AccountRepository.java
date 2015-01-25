package cashew.repository;

import cashew.entities.Account;
import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.Repository;
/**
 * Created by Shipeng Xu on 25/1/15.
 */
public interface AccountRepository extends Repository<Account, Long> {
    void save(Account account) throws DataAccessException;
}
