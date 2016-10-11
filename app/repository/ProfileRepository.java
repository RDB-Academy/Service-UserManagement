package repository;

import com.google.inject.ImplementedBy;

import form.LoginForm;
import form.SignUpForm;

import models.Profile;

/**
 *
 * @author Fabio Mazzone [fabio.mazzone@me.com]
 */
@ImplementedBy(ProfileRepositoryEbean.class)
public interface ProfileRepository {
    Profile create(SignUpForm signUpForm);

    Profile getProfileByEmail(LoginForm loginForm);

    Profile getProfileByUsername(String username);

}
