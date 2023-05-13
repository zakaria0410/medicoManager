package com.medicoManager.settingsservice.dto;

import java.time.LocalDate;

public class MedicamentDto extends AbstractNameSettingsDto{


    private String description;
    private Double prix;
    private String dosage;
    private String forme;
    private LocalDate dateDePeremption;

    //constructeurs
    public MedicamentDto() {}

    public MedicamentDto(String description, Double prix, String dosage, String forme, LocalDate dateDePeremption) {

        this.description = description;
        this.prix = prix;
        this.dosage = dosage;
        this.forme = forme;
        this.dateDePeremption = dateDePeremption;
    }

    //getters and setters


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

    public String getForme() {
        return forme;
    }

    public void setForme(String forme) {
        this.forme = forme;
    }

    public LocalDate getDateDePeremption() {
        return dateDePeremption;
    }

    public void setDateDePeremption(LocalDate dateDePeremption) {
        this.dateDePeremption = dateDePeremption;
    }
}
