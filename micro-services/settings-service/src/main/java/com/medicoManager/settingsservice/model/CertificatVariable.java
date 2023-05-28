package com.medicoManager.settingsservice.model;

// Entité (Entity) - CertificatVariable.java
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "certificat_variable")
public class CertificatVariable extends AbstractNameSettings{

    private String displayName;
    private String defaultValue;

    // Constructeurs, getters et setters

    public CertificatVariable() {
    }

    public CertificatVariable(String name, String displayName, String defaultValue) {
          this.displayName = displayName;
        this.defaultValue = defaultValue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

