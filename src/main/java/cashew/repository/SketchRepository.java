package cashew.repository;

import cashew.entities.Sketch;
import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.Repository;
/**
 * Created by Shipeng Xu on 25/1/15.
 */
public interface SketchRepository extends Repository<Sketch, Long> {
    void save(Sketch sketch) throws DataAccessException;
}
