package com.medicoManager.settingsservice.dto;

public class BilanNumeriqueDto extends BilanDto{
    private double valeur_min;
    private double valeur_max;

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


}
