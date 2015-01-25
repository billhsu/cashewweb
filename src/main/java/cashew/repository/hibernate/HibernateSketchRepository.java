package cashew.repository.hibernate;

import cashew.entities.Sketch;
import cashew.repository.SketchRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import javax.inject.Inject;

/**
 * Created by Shipeng Xu on 25/1/15.
 */
@Repository
public class HibernateSketchRepository implements SketchRepository{
    private SessionFactory sessionFactory;
    @Inject
    public HibernateSketchRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }
    public void save(Sketch sketch) throws DataAccessException {
        
    }
}
