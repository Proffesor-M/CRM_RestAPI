package com.hevo;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

public class DataConfig extends Configuration {
    @JsonProperty
    private String message;
    @JsonProperty
    private int messageRepetitions;
    public String getMessage() {
        return message;
    }
    public int getMessageRepetitions() {
        return messageRepetitions;
    }
}
