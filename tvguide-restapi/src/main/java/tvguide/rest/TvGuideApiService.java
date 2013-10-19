package tvguide.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * A simple REST service which is able to say hello to someone using BroadcastService Please take a look at the web.xml where JAX-RS
 * is enabled And notice the @PathParam which expects the URL to contain /json/David or /xml/Mary
 *
 * @author Miguel Reyes
 */

@Path("/json/{name}")
public class TvGuideApiService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getHelloWorldJSON(@PathParam("name") String name) {
        System.out.println("name: " + name);
        return "{\"result\":\"" + "Hello " + name + "\"}";
    }

}
