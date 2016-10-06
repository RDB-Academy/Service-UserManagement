package authenticator.form;

/**
 *
 * @author Fabio Mazzone [fabio.mazzone@me.com]
 */
public class LoginForm {
    protected String email;
    protected String password;

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }
}
