package repository;

import com.avaje.ebean.Model;
import form.LoginForm;
import form.SignUpForm;
import models.Profile;

/**
 * @author Fabio Mazzone [fabio.mazzone@me.com]
 */
class ProfileRepositoryEbean implements ProfileRepository {
    private Model.Finder<Long, Profile> find = new Model.Finder<>(Profile.class);

    @Override
    public Profile create(SignUpForm signUpForm) {
        return null;
    }

    @Override
    public Profile getProfileByEmail(LoginForm loginForm) {
        String email = loginForm.getEmail();
        Profile profile = find.where().eq("email", email).findUnique();
        if (profile == null) {
            System.out.println("Profile not found with email " + email);
            return null;
        }
        return profile;
    }

    @Override
    public Profile getProfileByUsername(String username) {
        Profile profile = find.where().eq("username", username).findUnique();
        if (profile == null) {
            System.out.println("Profile not found with username " + username);
            return null;
        }
        return profile;
    }
}
