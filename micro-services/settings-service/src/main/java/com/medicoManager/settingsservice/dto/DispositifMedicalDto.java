package com.medicoManager.settingsservice.dto;

import com.medicoManager.settingsservice.model.AbstractNameSettings;

import javax.persistence.Entity;
import javax.persistence.Table;


public class DispositifMedicalDto extends AbstractNameSettingsDto {

private double prix_achat;
private double prix_location;
private String unite_mesure;

    public double getPrix_achat() {
        return prix_achat;
    }

    public void setPrix_achat(double prix_achat) {
        this.prix_achat = prix_achat;
    }

    public double getPrix_location() {
        return prix_location;
    }

    public void setPrix_location(double prix_location) {
        this.prix_location = prix_location;
    }

    public String getUnite_mesure() {
        return unite_mesure;
    }

    public void setUnite_mesure(String unite_mesure) {
        this.unite_mesure = unite_mesure;
    }
}

