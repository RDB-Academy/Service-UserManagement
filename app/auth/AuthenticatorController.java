package auth;

import auth.form.LoginForm;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * This Class handles all Authenticator Actions.
 *
 * @author Fabio Mazzone [fabio.mazzone@me.com]
 */
public class AuthenticatorController extends Controller {

    /**
     * POST /auth/login
     *  Accept:         application/vnd.api+json
     *  Content-Type:   application/vnd.api+json
     *  Payload:
     *      {
     *          loginForm: {
     *              email:      "max.mustermann@mail.de",
     *              password:   "password"
     *          }
     *      }
     *
     * @return this method returns a api token which the client must use to access the api
     */
    @BodyParser.Of(LoginFormBodyParser.class)
    public Result login() {
        LoginForm loginForm = request().body().as(LoginForm.class);
        System.out.println(loginForm);

        //if(Credential.authenticate(loginForm)) {

        //}
        /*
         * possible return values
         * 200 - ok             || authentication successfully
         * 401 - Unauthorized   || authentication failure
         */
        return TODO;
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
