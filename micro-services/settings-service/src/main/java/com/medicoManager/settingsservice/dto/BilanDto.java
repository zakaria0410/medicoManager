package com.medicoManager.settingsservice.dto;

import java.time.LocalDate;

public class BilanDto extends AbstractNameSettingsDto{
private Boolean isNumerique;
    private String resultatTextuel;
    private double valeur_min;
    private double valeur_max;
    private String codification;
    private String uniteMesure;

    public String getUniteMesure() {
        return uniteMesure;
    }

    public void setUniteMesure(String uniteMesure) {
        this.uniteMesure = uniteMesure;
    }

    public String getCodification() {
        return codification;
    }

    public void setCodification(String codification) {
        this.codification = codification;
    }

    public Boolean getNumerique() {
        return isNumerique;
    }

    public void setNumerique(Boolean numerique) {
        isNumerique = numerique;
    }

    public String getResultatTextuel() {
        return resultatTextuel;
    }

    public void setResultatTextuel(String resultatTextuel) {
        this.resultatTextuel = resultatTextuel;
    }

    public double getValeur_min() {
        return valeur_min;
    }

    public void setValeur_min(double valeur_min) {
        this.valeur_min = valeur_min;
    }

    public double getValeur_max() {
        return valeur_max;
    }

    public void setValeur_max(double valeur_max) {
        this.valeur_max = valeur_max;
    }
    //getters and setters



}
