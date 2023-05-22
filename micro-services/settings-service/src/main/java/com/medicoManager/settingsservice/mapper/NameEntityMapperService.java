package com.medicoManager.settingsservice.mapper;

import com.medicoManager.settingsservice.dto.AbstractNameSettingsDto;
import com.medicoManager.settingsservice.dto.BaseDTO;
import com.medicoManager.settingsservice.model.AbstractNameSettings;
import com.medicoManager.settingsservice.model.BaseEntity;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.InvocationTargetException;

public abstract class NameEntityMapperService<E extends AbstractNameSettings, D extends AbstractNameSettingsDto> extends BaseEntityMapperService<E,D> {

    @Override
    public E toEntity(D dto) {
        E entity= super.toEntity(dto);
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        return entity;
    }

    @Override
    public D toDto(E e) {
        D dto=super.toDto(e);
        dto.setName(e.getName());
        dto.setDescription(e.getDescription());
        return dto;
    }
}
