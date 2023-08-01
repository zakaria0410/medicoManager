package com.medicoManager.settingsservice.dto;

import com.medicoManager.settingsservice.model.User;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


public class MedcinDto extends UserDto {

    private String specialite;
    private String nordre;

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public String getNordre() {
        return nordre;
    }

    public void setNordre(String nordre) {
        this.nordre = nordre;
    }
    // Autres getters et setters
}

