package com.newtownscriptkiddies.ama.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;
import org.hibernate.validator.constraints.NotEmpty;

public class Question {
    @NotEmpty
    private String text;
    @NotEmpty
    private String category;
    private UUID id;

    public Question() {}

    public Question(UUID id, String text, String category) {
        this.id = id;
        this.text = text;
        this.category = category;
    }

    @JsonProperty
    public String getText() {
        return text;
    }

    @JsonProperty
    public void setText(String text) {
        this.text = text;
    }

    @JsonProperty
    public String getCategory() {
        return category;
    }

    @JsonProperty
    public void setCategory(String category) {
        this.category = category;
    }

    @JsonProperty
    public UUID getId() {
        return id;
    }
}
