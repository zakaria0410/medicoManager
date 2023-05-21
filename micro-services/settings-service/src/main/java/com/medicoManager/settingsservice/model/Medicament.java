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

    @Column(name = "prix")
    private Double prix;

    @Column(name = "dosage")
    private String dosage;

    @Column(name = "contre_indication")
    private String contreIndication;

    private String fabricant;
    @Column(name = "date_de_peremption")
    private LocalDate dateDePeremption;

    public String getContreIndication() {
        return contreIndication;
    }

    public void setContreIndication(String contre_indication) {
        this.contreIndication = contre_indication;
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



    public LocalDate getDateDePeremption() {
        return dateDePeremption;
    }

    public void setDateDePeremption(LocalDate dateDePeremption) {
        this.dateDePeremption = dateDePeremption;
    }
}

