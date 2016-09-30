package bodyParser;

import akka.util.ByteString;
import com.fasterxml.jackson.databind.JsonNode;
import play.api.http.HttpConfiguration;
import play.http.HttpErrorHandler;
import play.libs.F;
import play.libs.streams.Accumulator;
import play.mvc.BodyParser;
import play.mvc.BodyParsers;
import play.mvc.Http;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.concurrent.CompletionStage;
import java.util.function.Function;

/**
 * Parse the body as Json if the Content-Type is application/vnd.api+json.
 *
 * @author Fabio Mazzone [fabio.mazzone@me.com]
 */
public class JsonAPIBodyParser extends BodyParser.TolerantJson {
    private final HttpErrorHandler errorHandler;

    public JsonAPIBodyParser(long maxLength, HttpErrorHandler errorHandler) {
        super(maxLength, errorHandler);
        this.errorHandler = errorHandler;
    }

    @Inject
    public JsonAPIBodyParser(HttpConfiguration httpConfiguration, HttpErrorHandler errorHandler) {
        super(httpConfiguration, errorHandler);
        this.errorHandler = errorHandler;
    }

    @Override
    public Accumulator<ByteString, F.Either<Result, JsonNode>> apply(Http.RequestHeader request) {
        if(!request.contentType().map(ct -> ct.equalsIgnoreCase("application/vnd.api+json")).orElse(false)) {
            CompletionStage<Result> result = errorHandler.onClientError(request, Http.Status.UNSUPPORTED_MEDIA_TYPE, "Expected application/vnd.api+json");
            return Accumulator.done(result.thenApply(F.Either::Left));
        }
        if(!request.accepts("application/vnd.api+json")) {
            CompletionStage<Result> result = errorHandler.onClientError(request, Http.Status.NOT_ACCEPTABLE, "Expected application/vnd.api+json");
            return Accumulator.done(result.thenApply(F.Either::Left));
        }
        return super.apply(request);
    }
}
