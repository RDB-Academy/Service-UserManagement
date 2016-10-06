package models;

import com.avaje.ebean.Model;
import play.data.validation.Constraints.Email;
import play.data.validation.Constraints.Required;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 *
 * @author Fabio Mazzone [fabio.mazzone@me.com]
 */
public class User extends Model {
    @Id
    private long id;

    @Email
    @Required
    @Column(unique = true, length = 255)
    private String email;

    public User(String email) {

    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return this.email;
    }

}
