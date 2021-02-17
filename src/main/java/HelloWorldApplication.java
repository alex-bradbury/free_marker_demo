import health.TemplateHealthCheck;
import io.dropwizard.Application;
import io.dropwizard.forms.MultiPartBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;
import resources.BankDetailsResource;
import resources.EnterNameResource;
import resources.HelloResource;
import resources.HelloWorldResource;

public class HelloWorldApplication extends Application<HelloWorldConfiguration> {

    public static void main(String[] args) throws Exception{
        new HelloWorldApplication().run(args);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void initialize(Bootstrap<HelloWorldConfiguration> bootstrap) {
        bootstrap.addBundle(new ViewBundle());
        bootstrap.addBundle(new MultiPartBundle());

    }

    @Override
    public void run(HelloWorldConfiguration helloWorldConfiguration, Environment environment){
        //JSON API resources
        final HelloWorldResource resource = new HelloWorldResource("Hello %s!","World");
        final TemplateHealthCheck healthCheck = new TemplateHealthCheck("Hello %s!");

        environment.jersey().register(resource);
        environment.healthChecks().register("template", healthCheck);

        //HTML endpoints
        environment.jersey().register(new HelloResource());
        environment.jersey().register(new EnterNameResource());
        environment.jersey().register(new BankDetailsResource());

        //Validation Mapper
        environment.jersey().register(new BankDetailsViolationExceptionMapper());
    }
}
