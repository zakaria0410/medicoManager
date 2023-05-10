package com.medicoManager.settingsservice.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "medicament")
public class Medicament extends AbstractNameSettings {

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

