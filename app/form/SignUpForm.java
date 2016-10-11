package form;

import play.data.validation.Constraints;

/**
 * Created by fabiomazzone on 10.10.16.
 */
public class SignUpForm extends LoginForm {
    @Constraints.Email
    @Constraints.Required
    private
    String email;
    @Constraints.Required
    private
    String password;
    @Constraints.Required
    private String username;

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
}
