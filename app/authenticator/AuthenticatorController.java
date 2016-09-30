package authenticator;

import bodyParser.JsonAPIBodyParser;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * This Class handles all Authenticator Actions.
 *
 * @author Fabio Mazzone [fabio.mazzone@me.com]
 */
public class AuthenticatorController extends Controller {
    class LoginForm {
        protected String email;
        protected String password;
    }

    /**
     * This Methods validate the posted user credentials.
     * The function expect a JSON Object with the field "e-mail" and "password"
     *
     * @return this method returns a api token which the client must use to access the api
     */
    @BodyParser.Of(JsonAPIBodyParser.class)
    public Result login() {
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
