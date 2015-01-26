package cashew.service;

import cashew.entities.Sketch;
import cashew.repository.SketchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Created by Shipeng Xu on 26/1/15.
 */
@Service("sketchService")
public class SketchServiceImpl implements SketchService {
    @Autowired
    private SketchRepository sketchRepository;
    
    @Transactional(readOnly = true)
    public Sketch createSketch() {
        return new Sketch();
    }

    @Transactional
    public Sketch saveSketch(Sketch sketch) throws DataAccessException {
        return sketchRepository.save(sketch);
    }
    
    @Transactional(readOnly = true)
    public Collection<Sketch> findSketches() throws DataAccessException {
        return sketchRepository.findAll();
    }
}
