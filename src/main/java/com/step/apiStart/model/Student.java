package com.step.apiStart.model;

import java.util.UUID;

public class Student {
    private UUID id;
    private String name;
    private String group;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Student(UUID id, String name, String group) {
        this.id = id;
        this.name = name;
        this.group = group;
    }
}
