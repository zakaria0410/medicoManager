package com.medicoManager.settingsservice.dto;

import javax.persistence.Column;

public class VitalParameterDto extends AbstractNameSettingsDto{

    private double valeurMin;


    private double valeurMax;


    private String uniteMesure;

    public double getValeurMin() {
        return valeurMin;
    }

    public void setValeurMin(double valeurMin) {
        this.valeurMin = valeurMin;
    }

    public double getValeurMax() {
        return valeurMax;
    }

    public void setValeurMax(double valeurMax) {
        this.valeurMax = valeurMax;
    }

    public String getUniteMesure() {
        return uniteMesure;
    }

    public void setUniteMesure(String uniteMesure) {
        this.uniteMesure = uniteMesure;
    }
}
