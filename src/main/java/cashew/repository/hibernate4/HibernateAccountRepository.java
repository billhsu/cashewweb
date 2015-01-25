package cashew.repository.hibernate4;

import cashew.entities.Account;
import cashew.repository.AccountRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import javax.inject.Inject;

/**
 * Created by shipxu on 25/1/15.
 */
@Repository
public class HibernateAccountRepository implements AccountRepository {
    private SessionFactory sessionFactory;
    @Inject
    public HibernateAccountRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }
    public void save(Account account) throws DataAccessException {
        
    }
}
