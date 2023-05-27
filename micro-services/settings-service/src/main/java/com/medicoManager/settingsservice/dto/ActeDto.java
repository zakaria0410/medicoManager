package com.medicoManager.settingsservice.dto;

import com.medicoManager.settingsservice.model.DispositifMedical;
import com.medicoManager.settingsservice.model.MatierePremiere;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.List;

public class ActeDto extends AbstractNameSettingsDto{


    private String codification;



    private Double prix_unitaire;

    private List<MatierePremiereDto> matieres;


    private List<DispositifMedicalDto> dispositifsMedicaux;

    public String getCodification() {
        return codification;
    }

    public void setCodification(String codification) {
        this.codification = codification;
    }





    public Double getPrix_unitaire() {
        return prix_unitaire;
    }

    public void setPrix_unitaire(Double prix_unitaire) {
        this.prix_unitaire = prix_unitaire;
    }

    public List<MatierePremiereDto> getMatieres() {
        return matieres;
    }

    public void setMatieres(List<MatierePremiereDto> matieres) {
        this.matieres = matieres;
    }

    public List<DispositifMedicalDto> getDispositifsMedicaux() {
        return dispositifsMedicaux;
    }

    public void setDispositifsMedicaux(List<DispositifMedicalDto> dispositifsMedicaux) {
        this.dispositifsMedicaux = dispositifsMedicaux;
    }
    private List<String> dispositifs;


    private List<String> matieress;

    public List<String> getDispositifs() {
        return dispositifs;
    }

    public void setDispositifs(List<String> dispositifs) {
        this.dispositifs = dispositifs;
    }

    public List<String> getMatieress() {
        return matieress;
    }

    public void setMatieress(List<String> matieress) {
        this.matieress = matieress;
    }
}
