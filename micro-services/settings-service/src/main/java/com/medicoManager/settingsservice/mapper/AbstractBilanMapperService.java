package com.medicoManager.settingsservice.mapper;

import com.medicoManager.settingsservice.dto.BilanDto;
import com.medicoManager.settingsservice.model.Bilan;
import org.springframework.stereotype.Service;


public abstract class AbstractBilanMapperService<E extends Bilan> extends NameEntityMapperService<E, BilanDto> {

    @Override
    public E toEntity(BilanDto dto) {
        E entity= super.toEntity(dto);
        entity.setCodification(dto.getCodification());
        return entity;
    }

    @Override
    public BilanDto toDto(E bilan) {
        BilanDto bilanDto= super.toDto(bilan);
        bilanDto.setCodification(bilan.getCodification());
        return bilanDto;
    }

}
