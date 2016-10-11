package controller;

import form.SignUpForm;
import models.Profile;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import repository.ProfileRepository;
import service.ProfileService;

import javax.inject.Inject;

/**
 * @author Fabio Mazzone [fabio.mazzone@me.com]
 */
public class ProfileController extends Controller {
    @Inject
    FormFactory formFactory;

    @Inject
    private ProfileService profileService;

    @Inject
    private ProfileRepository profileRepository;

    /**
     * Sign Up
     * @return
     */
    public Result create() {
        Form<SignUpForm> form = formFactory.form(SignUpForm.class).bindFromRequest();
        if(form.hasErrors()) {
            System.out.println(form.errors());
            return badRequest(form.errorsAsJson());
        }
        SignUpForm signUpForm = form.get();
        Profile profile = profileService.create(signUpForm);

        return ok();
    }

    /**
     * View own Profile
     * @return
     */
    public Result read() {
        // Get Session
        Profile profile = null;

        return TODO;
    }

    public Result read(String username) {
        Profile profile = profileRepository.getProfileByUsername(username);

        return TODO;
    }


}
