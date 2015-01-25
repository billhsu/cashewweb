package cashew.entities;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Shipeng Xu on 19/1/15.
 */
@Entity
@Table(name="sketches")
public class Sketch implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    @NotNull
    private Account owner;
    
    @Column(name = "filename", unique = true)
    @NotEmpty
    String filename;

    @Column(name = "desc")
    String desc;

    @Column(name = "date_uploaded")
    @Temporal(TemporalType.TIME)
    @NotEmpty
    Date dateUploaded;

    public Long getId() { return this.id; }
    public void setId(Long id) { this.id = id; }
    
    public String getFilename() { return this.filename; }
    public void setFilename(String filename) { this.filename = filename; }

    public String getDesc() { return this.desc; }
    public void setDesc(String desc) { this.desc = desc; }
    
    protected void setOwner(Account owner) {
        this.owner = owner;
    }

    public Date getDataUploaded() { return this.dateUploaded; }
    public void setDateUploaded(Date date) { this.dateUploaded = date; }
}
