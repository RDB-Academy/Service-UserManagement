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

/**
 * Parse the body as Json if the Content-Type is text/json or application/vnd.api+json.
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
        System.out.println("JsonAPIBodyParser");
        System.out.println(request.contentType().get());

        return BodyParsers.validateContentType(errorHandler, request, "Expected application/vnd.api+json",
                ct -> ct.equalsIgnoreCase("application/vnd.api+json"),
                super::apply
        );
    }
}
