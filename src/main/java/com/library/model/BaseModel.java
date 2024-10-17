package com.library.model;

import jakarta.xml.bind.annotation.XmlAttribute;
public abstract class BaseModel {
    protected int id;

    public int getId() {
        return id;
    }

    @XmlAttribute
    public void setId(int id) {
        this.id = id;
    }
}
