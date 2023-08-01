package com.medicoManager.settingsservice.dto;

import com.medicoManager.settingsservice.model.AbstractPersonne;

import javax.persistence.Entity;


public class PatientDto extends AbstractPersonneDto {


    private boolean accesApplication;
    private String numeroSecuriteSociale;
    private String groupeSanguin;
    private String cin;
    private String nCnss;
    private String mutuelle;
    private String nMutuelle;
    private String antecedentsCliniques;
    private String antecedentsFamiliaux;
    private String antecedentsChirurgicaux;
    private String numeroTelephoneUrgence;
    // Autres attributs pertinents pour un patient

    // Getters et setters


    public boolean isAccesApplication() {
        return accesApplication;
    }

    public void setAccesApplication(boolean accesApplication) {
        this.accesApplication = accesApplication;
    }

    public String getNumeroSecuriteSociale() {
        return numeroSecuriteSociale;
    }

    public void setNumeroSecuriteSociale(String numeroSecuriteSociale) {
        this.numeroSecuriteSociale = numeroSecuriteSociale;
    }

    public String getGroupeSanguin() {
        return groupeSanguin;
    }

    public void setGroupeSanguin(String groupeSanguin) {
        this.groupeSanguin = groupeSanguin;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getNCnss() {
        return nCnss;
    }

    public void setNCnss(String nCnss) {
        this.nCnss = nCnss;
    }

    public String getMutuelle() {
        return mutuelle;
    }

    public void setMutuelle(String mutuelle) {
        this.mutuelle = mutuelle;
    }

    public String getNMutuelle() {
        return nMutuelle;
    }

    public void setNMutuelle(String nMutuelle) {
        this.nMutuelle = nMutuelle;
    }

    public String getAntecedentsCliniques() {
        return antecedentsCliniques;
    }

    public void setAntecedentsCliniques(String antecedentsCliniques) {
        this.antecedentsCliniques = antecedentsCliniques;
    }

    public String getAntecedentsFamiliaux() {
        return antecedentsFamiliaux;
    }

    public void setAntecedentsFamiliaux(String antecedentsFamiliaux) {
        this.antecedentsFamiliaux = antecedentsFamiliaux;
    }

    public String getAntecedentsChirurgicaux() {
        return antecedentsChirurgicaux;
    }

    public void setAntecedentsChirurgicaux(String antecedentsChirurgicaux) {
        this.antecedentsChirurgicaux = antecedentsChirurgicaux;
    }

    public String getNumeroTelephoneUrgence() {
        return numeroTelephoneUrgence;
    }

    public void setNumeroTelephoneUrgence(String numeroTelephoneUrgence) {
        this.numeroTelephoneUrgence = numeroTelephoneUrgence;
    }

    // Autres getters et setters
}

