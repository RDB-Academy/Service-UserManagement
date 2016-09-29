import play.Configuration;
import play.Environment;
import play.api.OptionalSourceMapper;
import play.api.routing.Router;
import play.http.HttpErrorHandler;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Results;
import scala.Option;

import javax.inject.Inject;
import javax.inject.Provider;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

/**
 *
 *
 * @author Fabio Mazzone [fabio.mazzone@me.com]
 */
public class ErrorHandler implements HttpErrorHandler {

    private final Option<String> playEditor;
    private final Environment environment;
    private final OptionalSourceMapper sourceMapper;
    private final Provider<Router> routes;

    @Inject
    public ErrorHandler(Configuration configuration, Environment environment,
                                   OptionalSourceMapper sourceMapper, Provider<Router> routes) {
        this.environment = environment;
        this.sourceMapper = sourceMapper;
        this.routes = routes;

        this.playEditor = Option.apply(configuration.getString("play.editor"));
    }


    @Override
    public CompletionStage<Result> onClientError(Http.RequestHeader request, int statusCode, String message) {
        switch (statusCode) {
            case w



                }
        return CompletableFuture.completedFuture(Results.badRequest(message));
    }

    @Override
    public CompletionStage<Result> onServerError(Http.RequestHeader request, Throwable exception) {
        return null;
    }
}
