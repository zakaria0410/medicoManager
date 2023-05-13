package com.medicoManager.settingsservice.mapper;

import com.medicoManager.settingsservice.dto.BilanDto;
import com.medicoManager.settingsservice.dto.MedicamentDto;
import com.medicoManager.settingsservice.model.Bilan;
import com.medicoManager.settingsservice.model.Medicament;
import org.springframework.stereotype.Service;

@Service
public  class BilanMapperService extends NameEntityMapperService<Bilan, BilanDto> {


    @Override
    protected Class<BilanDto> getDtoClass() {
        return BilanDto.class;
    }

    @Override
    protected Class<Bilan> getEntityClass() {
        return Bilan.class;
    }
}
