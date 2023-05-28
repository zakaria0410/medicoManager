package com.medicoManager.settingsservice.dto;

import com.medicoManager.settingsservice.model.AbstractNameSettings;

import javax.persistence.Entity;
import javax.persistence.Table;

public class CertificatMedicalTypeDto extends AbstractNameSettingsDto {

private String title;
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

