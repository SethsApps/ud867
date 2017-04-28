package me.sethallen.jokeprovider;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import me.sethallen.javajoker.JokeProvider;

/**
 * The endpoint class for retrieving jokes.
 */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "jokeprovider.sethallen.me",
                ownerName = "jokeprovider.sethallen.me",
                packagePath = ""
        )
)
public class MyEndpoint {

    private static final JokeProvider mJokeProvider = new JokeProvider();

    /**
     * Endpoint method that retrieves a joke and returns it.
     */
    @ApiMethod(name = "getJoke")
    public MyBean getJoke() {
        String theJoke =  mJokeProvider.makeMeLaugh();

        MyBean response = new MyBean();
        response.setData(theJoke);

        return response;
    }
}