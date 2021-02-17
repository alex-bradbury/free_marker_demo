package models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Name {
    private String name;

    public Name() {
    }

    public Name(String name) {
        this.name = name;
    }

    @JsonProperty
    public String getName() {
        return name;
    }
}
