package cashew.repository.hibernate;

import cashew.entities.Account;
import cashew.repository.AccountRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import javax.inject.Inject;
import java.io.Serializable;

/**
 * Created by Shipeng Xu on 25/1/15.
 */
//@Repository
//public class HibernateAccountRepository implements AccountRepository {
//    private SessionFactory sessionFactory;
//    @Inject
//    public HibernateAccountRepository(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }
//
//    private Session currentSession() {
//        return sessionFactory.getCurrentSession();
//    }
//    public Account save(Account account) throws DataAccessException {
//        Serializable id = currentSession().save(account);
//        return new Account();
//    }
//}
