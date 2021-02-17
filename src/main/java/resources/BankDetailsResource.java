package resources;

import com.codahale.metrics.annotation.Timed;
import io.dropwizard.views.View;
import models.BankDetails;
import views.BankDetailsView;
import views.GoodBankDetailsView;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/")
@Produces(MediaType.TEXT_HTML)
public class BankDetailsResource {
    public BankDetailsResource() {
    }

    @GET
    @Timed
    public BankDetailsView getBankDetailsView(){
        return new BankDetailsView(new BankDetails());
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Timed
    public View bankDetailsResponse(@Valid @BeanParam BankDetails bankDetails) {
        //System.out.print(bankDetails.getNameOnAccount());
        if(bankDetails.checkDetails()){
            return new GoodBankDetailsView(bankDetails);
        }else{
            return new BankDetailsView(bankDetails);
        }

    }

}
