package cashew.entities;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.*;

/**
 * Created by Shipeng Xu on 12/1/15.
 */
@Entity
@Table(name="accounts")
public class Account implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "email", unique = true)
    @NotEmpty
    @Email
    private String email;

    @Column(name = "password")
    @NotEmpty
    private String password;

    @Column(name = "nickname", unique = true)
    @NotEmpty
    private String nickname;

    @Column(name = "salt")
    @NotEmpty
    private String salt;
    
    @Column(name = "date_joined")
    @NotNull
    private Date dateJoined;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Sketch> sketches;

    protected Set<Sketch> getSketchesInternal() {
        if (this.sketches == null) {
            this.sketches = new HashSet<Sketch>();
        }
        return this.sketches;
    }

    public List<Sketch> getSketches() {
        List<Sketch> sortedSketches = new ArrayList<Sketch>(getSketchesInternal());
        PropertyComparator.sort(sortedSketches, new MutableSortDefinition("dateUploaded", true, false));
        return Collections.unmodifiableList(sortedSketches);
    }

    public void addSketch(Sketch sketch) {
        sketch.setOwner(this);
        getSketchesInternal().add(sketch);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Date getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(Date dateJoined) {
        this.dateJoined = dateJoined;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", dateJoined=" + dateJoined +
                '}';
    }
}
