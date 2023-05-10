package com.medicoManager.settingsservice.mapper;

import com.medicoManager.settingsservice.dto.AbstractNameSettingsDto;
import com.medicoManager.settingsservice.dto.MedicamentDto;
import com.medicoManager.settingsservice.model.AbstractNameSettings;
import com.medicoManager.settingsservice.model.Medicament;
import org.springframework.stereotype.Service;

@Service
public  class MedicamentMapperService extends NameEntityMapperService<Medicament, MedicamentDto> {


    @Override
    protected Class<MedicamentDto> getDtoClass() {
        return MedicamentDto.class;
    }

    @Override
    protected Class<Medicament> getEntityClass() {
        return Medicament.class;
    }
}
