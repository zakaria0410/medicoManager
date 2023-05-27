package com.medicoManager.settingsservice.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "bilan_type")
public class BilanType extends AbstractNameSettings{


    // Relation ManyToMany avec Medicament
    @ManyToMany
    @JoinTable(
            name = "bilan_type_bilan",
            joinColumns = @JoinColumn(name = "bilan_type_id"),
            inverseJoinColumns = @JoinColumn(name = "bilan_id")
    )
    private List<Bilan> bilans;

    public List<Bilan> getBilans() {
        return bilans;
    }

    public void setBilans(List<Bilan> bilans) {
        this.bilans = bilans;
    }
// Constructeurs, getters, setters, etc.
}

