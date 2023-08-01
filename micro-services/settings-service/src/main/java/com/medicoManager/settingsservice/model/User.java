package com.medicoManager.settingsservice.model;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type")
public class User extends AbstractPersonne {

   private String username;
   private String kcId;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getKcId() {
        return kcId;
    }

    public void setKcId(String kcId) {
        this.kcId = kcId;
    }

// Autres attributs communs à toutes les personnes

}
