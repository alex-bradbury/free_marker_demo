package models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Greeting {
    private String greeting;

    public Greeting(){
    }

    public Greeting(String greeting) {
        this.greeting = greeting;
    }

    @JsonProperty
    public String getGreeting() {
        return greeting;
    }
}
