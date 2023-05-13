package com.medicoManager.settingsservice.model;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractNameSettings extends BaseEntity {

    private String name;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    // Getters and setters for name

    // Other common properties and methods for all name settings entities
}
