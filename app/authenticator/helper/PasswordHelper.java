package authenticator.helper;

import org.mindrot.jbcrypt.BCrypt;

import javax.inject.Singleton;

/**
 * @author Fabio Mazzone [fabio.mazzone@me.com]
 */
@Singleton
public class PasswordHelper {
    /**
     *
     * @param rawPassword
     * @return
     */
    public String hash(String rawPassword) {
        return BCrypt.hashpw(rawPassword, BCrypt.gensalt());
    }

    /**
     *
     * @param encryptedPassword
     * @param candidate
     * @return
     */
    public boolean matches(String encryptedPassword, String candidate) {
        return BCrypt.checkpw(candidate, encryptedPassword);
    }
}
