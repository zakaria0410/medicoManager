package com.medicoManager.settingsservice.dto;

// Entité (Entity) - CertificatVariable.java

import javax.persistence.*;

public class CertificatVariableDto extends AbstractNameSettingsDto{



    private String displayName;
    private String defaultValue;

    // Constructeurs, getters et setters

    public CertificatVariableDto() {
    }

    public CertificatVariableDto(String name, String displayName, String defaultValue) {

        this.displayName = displayName;
        this.defaultValue = defaultValue;
    }


    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }
}

