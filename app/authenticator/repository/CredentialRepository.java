package authenticator.repository;

import authenticator.form.LoginForm;
import authenticator.models.Credential;
import com.avaje.ebean.Model;
import models.User;

/**
 * @author Fabio Mazzone [fabio.mazzone@me.com]
 */
public class CredentialRepository extends Model {
    private static Finder<Long, Credential> find = new Finder<>(Credential.class);

    /**
     *
     * @param loginForm
     * @return
     */
    public static User authenticate(LoginForm loginForm) {
        return null;
    }
}
