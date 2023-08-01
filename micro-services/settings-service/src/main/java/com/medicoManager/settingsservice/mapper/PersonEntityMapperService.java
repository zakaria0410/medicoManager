package com.medicoManager.settingsservice.mapper;

import com.medicoManager.settingsservice.dto.AbstractPersonneDto;
import com.medicoManager.settingsservice.model.AbstractPersonne;

public abstract class PersonEntityMapperService<E extends AbstractPersonne, D extends AbstractPersonneDto> extends BaseEntityMapperService<E,D> {

    @Override
    public E toEntity(D dto) {
        E entity= super.toEntity(dto);
        entity.setPrenom(dto.getPrenom());
        entity.setNom(dto.getNom());
        entity.setAdresse(dto.getAdresse());
        entity.setCivilite(dto.getCivilite());
        entity.setEmail(dto.getEmail());
        entity.setTelephone1(dto.getTelephone1());
        entity.setTelephone2(dto.getTelephone2());
        return entity;
    }

    @Override
    public D toDto(E e) {
        D dto=super.toDto(e);
        dto.setPrenom(e.getPrenom());
        dto.setNom(e.getNom());
        dto.setAdresse(e.getAdresse());
        dto.setCivilite(e.getCivilite());
        dto.setEmail(e.getEmail());
        dto.setTelephone1(e.getTelephone1());
        dto.setTelephone2(e.getTelephone2());
        return dto;
    }
}
