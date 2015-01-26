package cashew.repository;

import cashew.entities.Sketch;
import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.Repository;

import java.util.Collection;

/**
 * Created by Shipeng Xu on 25/1/15.
 */
public interface SketchRepository extends Repository<Sketch, Long> {
    Sketch save(Sketch sketch) throws DataAccessException;
    Collection<Sketch> findAll() throws DataAccessException;
}
