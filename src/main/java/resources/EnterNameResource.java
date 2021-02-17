package resources;

import models.Name;
import com.codahale.metrics.annotation.Timed;
import views.GetNameView;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Optional;

@Path("/enter-name")
@Produces(MediaType.TEXT_HTML)
public class EnterNameResource {

    public EnterNameResource() {
    }

    @GET
    @Timed
    public GetNameView getNameView(){
        return new GetNameView(new Name(""));
    }

    @POST
    @Timed
    public GetNameView postName(@FormParam("name") Optional<String> queryName){
        Name name = new Name(queryName.orElse("Stranger"));
        System.out.print(name.getName()+"\n");
        return new GetNameView(name);
    }
}
