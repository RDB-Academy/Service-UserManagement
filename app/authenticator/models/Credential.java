package authenticator.models;

import com.avaje.ebean.Model;
import models.User;

import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

/**
 *
 * @author Fabio Mazzone [fabio.mazzone@me.com]
 */
public class Credential extends Model {
    @Id
    private long id;

    @OneToOne
    private User user;

    @Transient
    private String email;

    private String password;

    public Credential(User user, String password) {

    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return this.user.getEmail();
    }

}
