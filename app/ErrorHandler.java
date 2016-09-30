import akka.util.ByteString;
import com.google.common.collect.ImmutableMap;
import play.Configuration;
import play.Environment;
import play.api.OptionalSourceMapper;
import play.api.mvc.ResponseHeader;
import play.api.routing.Router;
import play.http.HttpEntity;
import play.http.HttpErrorHandler;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Results;
import play.twirl.api.Content;

import javax.inject.Inject;
import javax.inject.Provider;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

/**
 *
 *
 * @author Fabio Mazzone [fabio.mazzone@me.com]
 */
public class ErrorHandler implements HttpErrorHandler {

    private final Environment environment;
    private final OptionalSourceMapper sourceMapper;
    private final Provider<Router> routes;

    @Inject
    public ErrorHandler(
            Configuration configuration,
            Environment environment,
            OptionalSourceMapper sourceMapper,
            Provider<Router> routes) {
        this.environment = environment;
        this.sourceMapper = sourceMapper;
        this.routes = routes;
    }


    @Override
    public CompletionStage<Result> onClientError(Http.RequestHeader request, int statusCode, String message) {
        HttpEntity.Strict httpEntity;
        Result result;

        System.out.println("- onClientError: ");
        System.out.println("    - request   : " + request);
        System.out.println("    - StatusCode: " + statusCode);
        System.out.println("    - message   : " + message);

        switch (statusCode) {
            case Http.Status.BAD_REQUEST: // 400
                break;
            case Http.Status.UNAUTHORIZED: // 401
                break;
            case Http.Status.FORBIDDEN: // 403
                break;
            case Http.Status.NOT_FOUND: // 404
                return CompletableFuture.completedFuture(Results.notFound(message));
            case Http.Status.METHOD_NOT_ALLOWED: // 405
                break;
            case Http.Status.NOT_ACCEPTABLE: // 406
                httpEntity = new HttpEntity.Strict(ByteString.fromString(message + "\n"), Optional.of("application/vnd.api+json"));
                result = new Result(Http.Status.NOT_ACCEPTABLE, httpEntity);
                return CompletableFuture.completedFuture(result);
            case Http.Status.REQUEST_TIMEOUT: // 408
                break;
            case Http.Status.UNSUPPORTED_MEDIA_TYPE: // 415
                httpEntity = new HttpEntity.Strict(ByteString.fromString(message + "\n"), Optional.of("application/vnd.api+json"));
                result = new Result(Http.Status.UNSUPPORTED_MEDIA_TYPE, httpEntity);
                return CompletableFuture.completedFuture(result);
            case Http.Status.TOO_MANY_REQUESTS: // 429
                break;
            default:

        }
        return CompletableFuture.completedFuture(Results.badRequest(message));
    }

    @Override
    public CompletionStage<Result> onServerError(Http.RequestHeader request, Throwable exception) {
        System.out.println("- onServerError: ");
        System.out.println("    - request   : " + request);
        System.out.println("    - exception : " + exception);
        return CompletableFuture.completedFuture(Results.internalServerError("onServerError"));
    }
}
