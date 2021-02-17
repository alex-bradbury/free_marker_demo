package views;

import models.Name;
import io.dropwizard.views.View;

public class GetNameView extends View {
    private final Name name;

    public GetNameView(Name name){
        super("getName.ftl");
        this.name = name;
    }

    public Name getName(){
        return name;
    }
}
