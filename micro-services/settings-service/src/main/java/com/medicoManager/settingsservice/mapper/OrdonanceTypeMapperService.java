package com.medicoManager.settingsservice.mapper;

import com.medicoManager.settingsservice.dto.MedicamentDto;
import com.medicoManager.settingsservice.dto.OrdonanceTypeDto;
import com.medicoManager.settingsservice.model.Medicament;
import com.medicoManager.settingsservice.model.OrdonanceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public  class OrdonanceTypeMapperService extends NameEntityMapperService<OrdonanceType, OrdonanceTypeDto> {
@Autowired
private MedicamentMapperService medicamentMapperService;
    @Override
    public OrdonanceType toEntity(OrdonanceTypeDto dto) {
        OrdonanceType ordonanceType= super.toEntity(dto);
        ordonanceType.setMedicaments(dto.getMedicaments().stream().map(medicamentDto -> medicamentMapperService.toEntity(medicamentDto)).collect(Collectors.toList()));
return ordonanceType;    }

    @Override
    public OrdonanceTypeDto toDto(OrdonanceType ordonanceType) {
        OrdonanceTypeDto ordonanceTypeDto= super.toDto(ordonanceType);
        ordonanceTypeDto.setMedicaments(ordonanceType.getMedicaments().stream().map(medicament -> medicamentMapperService.toDto(medicament)).collect(Collectors.toList()));
        return ordonanceTypeDto;
    //    return super.toDto(ordonanceType);
    }

    @Override
    protected OrdonanceTypeDto instanciateDto() {
        return new OrdonanceTypeDto();
    }

    @Override
    protected OrdonanceType instanciateEntity() {
        return new OrdonanceType();
    }

    @Override
    protected Class<OrdonanceTypeDto> getDtoClass() {
        return OrdonanceTypeDto.class;
    }

    @Override
    protected Class<OrdonanceType> getEntityClass() {
        return OrdonanceType.class;
    }
}
