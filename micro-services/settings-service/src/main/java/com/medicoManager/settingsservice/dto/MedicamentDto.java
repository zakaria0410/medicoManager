package com.medicoManager.settingsservice.dto;

import java.time.LocalDate;

public class MedicamentDto extends AbstractNameSettingsDto{

    private String description;
    private Double prix;
    private String dosage;
    private String contreIndication;

    private String fabricant;
    private LocalDate dateDePeremption;

    //constructeurs


    //getters and setters





    public void setContreIndication(String contreIndication) {
        this.contreIndication = contreIndication;
    }

    public String getFabricant() {
        return fabricant;
    }

    public void setFabricant(String fabricant) {
        this.fabricant = fabricant;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getContreIndication() {
        return contreIndication;
    }


    public LocalDate getDateDePeremption() {
        return dateDePeremption;
    }

    public void setDateDePeremption(LocalDate dateDePeremption) {
        this.dateDePeremption = dateDePeremption;
    }
}
