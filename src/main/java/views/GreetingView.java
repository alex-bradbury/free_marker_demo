package views;

import models.Name;
import io.dropwizard.views.View;

public class GreetingView extends View {
    private final Name name;

    public GreetingView(Name name) {
        super("hello.ftl");
        this.name = name;
    }

    public Name getName() {
        return name;
    }
}
