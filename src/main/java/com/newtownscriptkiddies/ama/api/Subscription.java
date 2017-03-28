package com.newtownscriptkiddies.ama.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

public class Subscription {
    @NotEmpty
    private String endpoint;

    public Subscription() {}

    public Subscription(String endpoint) {
        this.endpoint = endpoint;
    }

    @JsonProperty
    public String getEndpoint() {
        return endpoint;
    }

    @JsonProperty
    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }
}
