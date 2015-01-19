package cashew.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

/**
 * Created by shipxu on 12/1/15.
 */
@Entity
@Table(name="accounts")
public class Account {
    private int id;
    private String email;
    private String password;
    private Date dateJoined;
}
