package authenticator.controller;

import authenticator.form.LoginForm;
import authenticator.repository.CredentialRepository;
import com.fasterxml.jackson.databind.JsonNode;
import models.User;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * This Class handles all Authenticator Actions.
 *
 * @author Fabio Mazzone [fabio.mazzone@me.com]
 */
public class AuthenticatorController extends Controller {
    /**
     * This Methods validate the posted user credentials.
     * The function expect a JSON Object with the field "e-mail" and "password"
     * {
     *     loginForm: {
     *         email:   "max.mustermann@mail.de",
     *         password:"password"
     *     }
     * }
     * @return this method returns a api token which the client must use to access the api
     */
    public Result login() {
        JsonNode jsonBody = request().body().asJson();
        LoginForm loginForm = Json.fromJson(jsonBody, LoginForm.class);
        User user = CredentialRepository.authenticate(loginForm);


        return null;
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
}
