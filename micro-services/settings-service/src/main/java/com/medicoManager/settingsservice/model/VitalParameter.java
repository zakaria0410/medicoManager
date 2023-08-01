package com.medicoManager.settingsservice.model;

import javax.persistence.*;

@Entity
@Table(name = "vital_parameters")
public class VitalParameter extends AbstractNameSettings{



    @Column(name = "valeur_min")
    private double valeurMin;

    @Column(name = "valeur_max")
    private double valeurMax;

    @Column(name = "unite_mesure")
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
