package com.medicoManager.settingsservice.mapper;

import com.medicoManager.settingsservice.dto.MedicamentDto;
import com.medicoManager.settingsservice.dto.OrdonanceTypeDto;
import com.medicoManager.settingsservice.model.Medicament;
import com.medicoManager.settingsservice.model.OrdonanceType;
import org.springframework.stereotype.Service;

@Service
public  class OrdonanceTypeMapperService extends NameEntityMapperService<OrdonanceType, OrdonanceTypeDto> {


    @Override
    protected Class<OrdonanceTypeDto> getDtoClass() {
        return OrdonanceTypeDto.class;
    }

    @Override
    protected Class<OrdonanceType> getEntityClass() {
        return OrdonanceType.class;
    }
}
