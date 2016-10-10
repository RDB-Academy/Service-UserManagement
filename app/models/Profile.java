package models;

import com.avaje.ebean.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Fabio Mazzone [fabio.mazzone@me.com]
 */
@Entity
public class Profile extends Model {
    @Id
    private long id;

    @Column(unique = true, length = 255, nullable = false)
    private String email;

    @Column(unique = true, length = 255, nullable = false)
    private String username;

    /**
     *
     * @return
     */
    public String getEmail() {
        return this.email;
    }

}
