package resources;

import models.Name;
import com.codahale.metrics.annotation.Timed;
import views.GreetingView;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Optional;

@Path("/greeting")
@Produces(MediaType.TEXT_HTML)
public class HelloResource {
    public static String defaultName = "Stranger";

    public HelloResource() {

    }

    @GET
    @Timed
    public GreetingView getGreeting(@QueryParam("name") Optional<String> queryName){
        Name name = new Name(queryName.orElse(defaultName));
        return new GreetingView(name);
    }

    @POST
    @Timed
    public GreetingView postGreeting(@FormParam("name") Optional<String> queryName){
        Name name = new Name(queryName.orElse(defaultName));
        System.out.print(name.getName()+"\n");
        return new GreetingView(name);
    }
}
