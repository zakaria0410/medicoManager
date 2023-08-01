package com.medicoManager.settingsservice.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("medcin")
public class Medcin extends User {

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

