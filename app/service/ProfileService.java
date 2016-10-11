package service;

import com.google.inject.ImplementedBy;
import form.LoginForm;
import form.SignUpForm;
import models.Profile;

/**
 * @author fabiomazzone
 */
@ImplementedBy(ProfileServiceDefault.class)
public interface ProfileService {
    Profile create(SignUpForm signUpForm);

    Profile authenticate(LoginForm loginForm);
}
