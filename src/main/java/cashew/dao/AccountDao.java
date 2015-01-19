package cashew.dao;

import cashew.entities.Account;
import cashew.entities.Sketch;

import java.util.List;

/**
 * Created by shipxu on 19/1/15.
 */
public interface AccountDao {
    public List<Sketch> getSketchesForAccount(Account account);
}
