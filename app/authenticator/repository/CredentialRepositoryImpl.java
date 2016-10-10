package authenticator.repository;

import authenticator.form.LoginForm;
import authenticator.helper.PasswordHelper;
import authenticator.models.Credential;
import com.avaje.ebean.Model;
import com.google.inject.Inject;
import models.Profile;

import javax.annotation.Nullable;

/**
 * @author Fabio Mazzone [fabio.mazzone@me.com]
 */
public class CredentialRepositoryImpl implements CredentialRepository{
    public static Model.Finder<Long, Credential> find = new Model.Finder<>(Credential.class);

    @Inject
    PasswordHelper passwordHelper;

    /**
     *
     * @param loginForm
     * @return
     */
    @Nullable
    public Profile authenticate(LoginForm loginForm) {
        find.query();
        System.out.println("Find the mail");
        Credential credential = find.query().where().eq("profile.email", loginForm.getEmail()).findUnique();
        System.out.println("Check the result");
        if (credential == null) {
            System.out.println("No Credentials Found :(");
            return null;
        }
        System.out.println("Yeah we have a member, let's check the password");
        if(passwordHelper.matches(credential.getPassword(), loginForm.getPassword())) {
            System.out.println("the password is correct");
            return credential.getProfile();
        }
        System.out.println("oh no the password is wrong");
        return null;
    }
}
