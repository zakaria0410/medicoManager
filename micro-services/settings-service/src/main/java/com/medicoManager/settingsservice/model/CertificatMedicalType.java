package com.medicoManager.settingsservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/*Je sousigné moi docteur ${certificat.doctorName} apres avoir consulté ${certificat.patientName} le
${certificat.patientBirthDate} j'ai constaté que son état de santé nécesitent un repos
de ${certificat.recommendedDuration} Jours du ${certificat.startDate} jusqu'au ${certificat.endDate}*/
@Entity
@Table(name = "certificat_type")
public class CertificatMedicalType extends AbstractNameSettings {

    private String title;

    @Column(length = 3500)
    private String paragraphe;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getParagraphe() {
        return paragraphe;
    }

    public void setParagraphe(String paragraphe) {
        this.paragraphe = paragraphe;
    }


}

