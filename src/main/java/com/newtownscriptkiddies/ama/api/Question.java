package com.newtownscriptkiddies.ama.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class Question {
    private String text;
    private String category;
    private List<String> tags;

    public Question() {}

    public Question(String text, String category, List<String> tags) {
        this.text = text;
        this.category = category;
        this.tags = tags;
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
    public List<String> getTags() {
        return tags;
    }

    @JsonProperty
    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
