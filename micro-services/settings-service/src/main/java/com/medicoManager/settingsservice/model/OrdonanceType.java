package com.medicoManager.settingsservice.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ordonance_type")
public class OrdonanceType extends AbstractNameSettings{


    // Relation ManyToMany avec Medicament
    @ManyToMany
    @JoinTable(
            name = "ordonance_type_medicament",
            joinColumns = @JoinColumn(name = "ordonance_type_id"),
            inverseJoinColumns = @JoinColumn(name = "medicament_id")
    )
    private List<Medicament> medicaments;

    public List<Medicament> getMedicaments() {
        return medicaments;
    }

    public void setMedicaments(List<Medicament> medicaments) {
        this.medicaments = medicaments;
    }
// Constructeurs, getters, setters, etc.
}

