package models;

import com.avaje.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.Id;

/**
 *
 * @author Fabio Mazzone [fabio.mazzone@me.com]
 */
public class User extends Model {
    @Id
    private long id;

    @Constraints.Email
    @Constraints.Required
    @Constraints.MaxLength(255)
    private String email;

    public User() {

    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return this.email;
    }

}
