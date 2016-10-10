package authenticator.models;

import com.avaje.ebean.Model;
import models.Profile;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

/**
 *
 * @author Fabio Mazzone [fabio.mazzone@me.com]
 */
@Entity
public class Credential extends Model {
    @Id
    private long id;
    @OneToOne
    private Profile profile;
    @Transient
    private String email;
    private String password;

    public String getEmail() {
        return this.profile.getEmail();
    }
    public String getPassword() {
        return password;
    }
    public Profile getProfile() {
        return profile;
    }
}
