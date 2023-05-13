package com.medicoManager.settingsservice.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("textuel")
public class BilanTextuel extends Bilan {
    private String resultatTextuel;


    public String getResultatTextuel() {
        return resultatTextuel;
    }

    public void setResultatTextuel(String resultatTextuel) {
        this.resultatTextuel = resultatTextuel;
    }

    // Getters et setters
}
