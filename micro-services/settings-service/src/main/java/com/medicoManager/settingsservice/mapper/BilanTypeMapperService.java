package com.medicoManager.settingsservice.mapper;

import com.medicoManager.settingsservice.dto.BilanTypeDto;
import com.medicoManager.settingsservice.dto.OrdonanceTypeDto;
import com.medicoManager.settingsservice.model.BilanType;
import com.medicoManager.settingsservice.model.OrdonanceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public  class BilanTypeMapperService extends NameEntityMapperService<BilanType, BilanTypeDto> {
@Autowired
private BilanMapperService bilanMapperService;
    @Override
    public BilanType toEntity(BilanTypeDto dto) {
        BilanType ordonanceType= super.toEntity(dto);
        ordonanceType.setBilans(dto.getBilans().stream().map(bilanDto -> bilanMapperService.toEntity(bilanDto)).collect(Collectors.toList()));
return ordonanceType;    }

    @Override
    public BilanTypeDto toDto(BilanType bilanType) {
        BilanTypeDto bilanTypeDto= super.toDto(bilanType);
        bilanTypeDto.setBilans(bilanType.getBilans().stream().map(medicament -> bilanMapperService.toDto(medicament)).collect(Collectors.toList()));
        return bilanTypeDto;
    //    return super.toDto(ordonanceType);
    }

    @Override
    public BilanTypeDto instanciateDto() {
        return new BilanTypeDto();
    }

    @Override
    public BilanType instanciateEntity() {
        return new BilanType();
    }

    @Override
    protected Class<BilanTypeDto> getDtoClass() {
        return BilanTypeDto.class;
    }

    @Override
    protected Class<BilanType> getEntityClass() {
        return BilanType.class;
    }
}
