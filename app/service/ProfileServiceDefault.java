package service;

import form.LoginForm;
import form.SignUpForm;
import helper.PasswordHelper;
import models.Profile;
import repository.ProfileRepository;
import scala.Tuple2;

import javax.inject.Inject;

/**
 * @author fabiomazzone
 */
class ProfileServiceDefault implements ProfileService {

    @Inject
    ProfileRepository profileRepository;

    @Override
    public Profile create(SignUpForm signUpForm) {
        Profile profile = new Profile();
        profile.setEmail(signUpForm.getEmail());
        this.setPassword(profile, signUpForm.getPassword());
        profile.setUsername(signUpForm.getUsername());

        profile.save();

        return null;
    }

    @Override
    public Profile authenticate(LoginForm loginForm) {
        Profile profile = profileRepository.getProfileByEmail(loginForm);
        if (profile == null) {
            System.out.println("Authentication failed");
            return null;
        }
        if (PasswordHelper.matches(profile.getPassword(), loginForm.getPassword())) {
            return profile;
        }
        return profile;
    }

    private void setPassword(Profile profile, String password) {
        String passwordHash = PasswordHelper.hash(password);
        profile.setPassword(passwordHash);
    }
}
