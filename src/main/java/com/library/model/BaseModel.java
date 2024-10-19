package com.library.model;

import com.fasterxml.jackson.annotation.JsonProperty;
public abstract class BaseModel {

    @JsonProperty("id")
    protected int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
