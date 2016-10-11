package controller;

import form.LoginForm;
import models.Profile;

import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import service.ProfileService;

import javax.inject.Inject;

/**
 * This Class handles all Authenticator Actions.
 *
 * @author Fabio Mazzone [fabio.mazzone@me.com]
 */
public class AuthenticatorController extends Controller {

    @Inject
    FormFactory formFactory;

    @Inject
    private ProfileService profileService;
    /**
     * This Methods validate the posted user credentials.
     * The function expect a JSON Object with the field "e-mail" and "password"
     * {
     *     email:   "max.mustermann@mail.de",
     *     password:"password"
     * }
     * @return this method returns a api token which the client must use to access the api
     */
    public Result login() {
        Form<LoginForm> form = formFactory.form(LoginForm.class).bindFromRequest();
        if(form.hasErrors()) {
            System.out.println(form.errors());
            // ToDo
            // Log BadRequest
            return badRequest(form.errorsAsJson());
        }
        LoginForm loginForm = form.get();
        System.out.println("Lets Check the password... ");
        Profile profile = profileService.authenticate(loginForm);
        if(profile != null) {
            System.out.println("Profile is NotNull ... ");
            return ok("login successfully");
        }
        System.out.println("Profile is Null ... ");
        // ToDo
        return forbidden("login failed");
    }

    public Result restore() {
        return TODO;
    }

    public Result isValid() {
        return TODO;
    }

    public Result logout() {
        return TODO;
    }

    public Result resetPassword() {
        return TODO;
    }
}
