import io.dropwizard.jersey.validation.ConstraintMessage;
import io.dropwizard.jersey.validation.JerseyViolationException;
import models.BankDetails;
import org.glassfish.jersey.server.model.Invocable;
import views.BankDetailsView;

import javax.validation.ConstraintViolation;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import java.util.Set;

public class BankDetailsViolationExceptionMapper implements ExceptionMapper<JerseyViolationException> {

    @Override
    public Response toResponse(JerseyViolationException e) {
        final Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        violations.forEach(v-> System.out.print(v.getInvalidValue()));
        final Invocable invocable = e.getInvocable();
        final int status = ConstraintMessage.determineStatus(violations, invocable);
        return Response.status(status)
                .type(MediaType.TEXT_HTML)
                .entity(status >= 500 ? "Server error" : new BankDetailsView(new BankDetails()))
                .build();
    }
}
