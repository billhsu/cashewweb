package cashew.service;

import cashew.entities.Sketch;
import org.springframework.dao.DataAccessException;

import java.util.Collection;

/**
 * Created by Shipeng Xu on 26/1/15.
 */
public interface SketchService {
    public Sketch createSketch();
    public Sketch saveSketch(Sketch sketch) throws DataAccessException;
    public Collection<Sketch> findSketches() throws DataAccessException;
}
