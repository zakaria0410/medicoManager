package com.medicoManager.settingsservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "medicament")
public class Medicament extends AbstractNameSettings {


    @Column(name = "description")
    private String description;

    @Column(name = "prix", nullable = false)
    private Double prix;

    @Column(name = "dosage")
    private String dosage;

    @Column(name = "forme")
    private String forme;

    @Column(name = "date_de_peremption")
    private LocalDate dateDePeremption;

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

