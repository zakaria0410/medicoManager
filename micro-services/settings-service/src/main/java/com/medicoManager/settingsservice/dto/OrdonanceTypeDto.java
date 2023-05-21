package com.medicoManager.settingsservice.dto;

import java.util.List;

public class OrdonanceTypeDto extends AbstractNameSettingsDto{

    private List<MedicamentDto> medicaments;



    public List<MedicamentDto> getMedicaments() {
        return medicaments;
    }

    public void setMedicaments(List<MedicamentDto> medicaments) {
        this.medicaments = medicaments;
    }
}
