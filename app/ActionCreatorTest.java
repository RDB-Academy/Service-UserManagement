import play.mvc.Action;
import play.mvc.Http;
import play.mvc.Result;

import java.lang.reflect.Method;
import java.util.concurrent.CompletionStage;

/**
 * @author Fabio Mazzone [fabio.mazzone@me.com]
 */
public class ActionCreatorTest implements play.http.ActionCreator {
    @Override
    public Action createAction(Http.Request request, Method actionMethod) {
        new Action.Simple() {
            @Override
            public CompletionStage<Result> call(Http.Context ctx) {
                return delegate.call(ctx);
            }
        };
        return null;
    }
}
