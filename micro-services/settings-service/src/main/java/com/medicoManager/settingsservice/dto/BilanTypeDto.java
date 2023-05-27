package com.medicoManager.settingsservice.dto;

import java.util.List;

public class BilanTypeDto extends AbstractNameSettingsDto{

    private List<BilanDto> bilans;

    public List<BilanDto> getBilans() {
        return bilans;
    }

    public void setBilans(List<BilanDto> bilans) {
        this.bilans = bilans;
    }
}
