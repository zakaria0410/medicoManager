package com.medicoManager.settingsservice.mapper;

import com.medicoManager.settingsservice.dto.UserDto;
import com.medicoManager.settingsservice.model.User;

public abstract class UserEntityMapperService<E extends User, D extends UserDto> extends PersonEntityMapperService<E,D> {

    @Override
    public E toEntity(D dto) {
        E entity= super.toEntity(dto);
      entity.setKcId(dto.getKcId());
      entity.setUsername(dto.getUsername());
        return entity;
    }

    @Override
    public D toDto(E e) {
        D dto=super.toDto(e);
        dto.setKcId(e.getKcId());
        dto.setUsername(e.getUsername());
        return dto;
    }
}
