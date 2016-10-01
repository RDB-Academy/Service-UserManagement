package auth;

import akka.util.ByteString;
import auth.form.LoginForm;
import com.fasterxml.jackson.databind.JsonNode;
import play.libs.F;
import play.libs.streams.Accumulator;
import play.mvc.BodyParser;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Results;

import javax.inject.Inject;
import java.util.concurrent.Executor;

/**
 * @author Fabio Mazzone [fabio.mazzone@me.com]
 */
public class LoginFormBodyParser implements BodyParser<LoginForm> {
    private BodyParser.Json jsonParser;
    private Executor executor;

   @Inject
    public LoginFormBodyParser(Json jsonParser, Executor executor) {
        this.jsonParser = jsonParser;
        this.executor = executor;
    }

    @Override
    public Accumulator<ByteString, F.Either<Result, LoginForm>> apply(Http.RequestHeader request) {
        Accumulator<ByteString, F.Either<Result, JsonNode>> jsonAccumulator = jsonParser.apply(request);
        return jsonAccumulator.map(resultOrJson -> {
            if(resultOrJson.left.isPresent()) {
                return F.Either.Left(resultOrJson.left.get());
            } else {
                JsonNode json = resultOrJson.right.get();
                try {
                    LoginForm loginForm = play.libs.Json.fromJson(json, LoginForm.class);
                    return F.Either.Right(loginForm);
                } catch (Exception e) {
                    return F.Either.Left(Results.badRequest("Unable to read LoginForm from json: " + e.getMessage()));
                }
            }
        }, executor);
    }
}
