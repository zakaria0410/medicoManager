package com.medicoManager.settingsservice.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("numerique")
public class BilanNumerique extends Bilan {
    private double valeur_min;
    private double valeur_max;
private String uniteMesure;
    public double getValeur_min() {
        return valeur_min;
    }

    public void setValeur_min(double valeur_min) {
        this.valeur_min = valeur_min;
    }

    public double getValeur_max() {
        return valeur_max;
    }

    public String getUniteMesure() {
        return uniteMesure;
    }

    public void setUniteMesure(String uniteMesure) {
        this.uniteMesure = uniteMesure;
    }

    public void setValeur_max(double valeur_max) {
        this.valeur_max = valeur_max;
    }
}
