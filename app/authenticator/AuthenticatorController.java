package authenticator;

import bodyParser.JsonAPIBodyParser;
import play.http.HttpErrorHandler;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.concurrent.CompletionStage;

/**
 * This Class handles all Authenticator Actions.
 *
 * @author Fabio Mazzone [fabio.mazzone@me.com]
 */
public class AuthenticatorController extends Controller {

    @Inject
    HttpErrorHandler errorHandler;

    class LoginForm {
        protected String email;
        protected String password;
    }

    /**
     * This Methods validate the posted user credentials.
     * The function expect a JSON Object with the field "e-mail" and "password"
     * {
     *     data: {
     *         type: "loginForm",
     *         id:   "max.mustermann@mail.de"
     *         attributes
     *     }
     * }
     * @return this method returns a api token which the client must use to access the api
     */
    @BodyParser.Of(JsonAPIBodyParser.class)
    public Result login() {
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
