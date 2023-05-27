package com.medicoManager.settingsservice.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Acte extends AbstractNameSettings{


    @Column(name = "codification")
    private String codification;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;
    @Column(name = "prix_unitaire")
    private Double prix_unitaire;
    @ManyToMany
    @JoinTable(
            name = "acte_matiere",
            joinColumns = @JoinColumn(name = "acte_id"),
            inverseJoinColumns = @JoinColumn(name = "matiere_id")
    )
    private List<MatierePremiere> matieres;

    @ManyToMany
    @JoinTable(
            name = "acte_dispositif",
            joinColumns = @JoinColumn(name = "acte_id"),
            inverseJoinColumns = @JoinColumn(name = "dispositif_id")
    )
    private List<DispositifMedical> dispositifsMedicaux;

    public String getCodification() {
        return codification;
    }

    public void setCodification(String codification) {
        this.codification = codification;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrix_unitaire() {
        return prix_unitaire;
    }

    public void setPrix_unitaire(Double prix_unitaire) {
        this.prix_unitaire = prix_unitaire;
    }

    public List<MatierePremiere> getMatieres() {
        return matieres;
    }

    public void setMatieres(List<MatierePremiere> matieres) {
        this.matieres = matieres;
    }

    public List<DispositifMedical> getDispositifsMedicaux() {
        return dispositifsMedicaux;
    }

    public void setDispositifsMedicaux(List<DispositifMedical> dispositifsMedicaux) {
        this.dispositifsMedicaux = dispositifsMedicaux;
    }
}
