package com.medicoManager.settingsservice.dto;

import com.medicoManager.settingsservice.model.AbstractNameSettings;

import javax.persistence.Entity;
import javax.persistence.Table;


public class MatierePremiereDto extends AbstractNameSettingsDto {

private double prix_achat;

private String unite_mesure;

    public double getPrix_achat() {
        return prix_achat;
    }

    public void setPrix_achat(double prix_achat) {
        this.prix_achat = prix_achat;
    }


    public String getUnite_mesure() {
        return unite_mesure;
    }

    public void setUnite_mesure(String unite_mesure) {
        this.unite_mesure = unite_mesure;
    }
}

