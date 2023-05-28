package com.medicoManager.settingsservice.mapper;

import com.medicoManager.settingsservice.dto.CertificatVariableDto;
import com.medicoManager.settingsservice.model.CertificatVariable;
import org.springframework.stereotype.Service;

@Service
public class CertificatVariableMapperService extends NameEntityMapperService<CertificatVariable, CertificatVariableDto> {


    @Override
    public CertificatVariable toEntity(CertificatVariableDto dto) {
        CertificatVariable entity = super.toEntity(dto);
        entity.setDefaultValue(dto.getDefaultValue());
        entity.setDisplayName(dto.getDisplayName());
        return entity;
    }

    @Override
    public CertificatVariableDto toDto(CertificatVariable entity) {
        CertificatVariableDto bilanDto = super.toDto(entity);
        bilanDto.setDefaultValue(entity.getDefaultValue());
        bilanDto.setDisplayName(entity.getDisplayName());
        return bilanDto;
    }

    @Override
    public CertificatVariableDto instanciateDto() {
        return new CertificatVariableDto();
    }

    @Override
    public CertificatVariable instanciateEntity() {
        return new CertificatVariable();
    }

    @Override
    protected Class<CertificatVariableDto> getDtoClass() {
        return CertificatVariableDto.class;
    }

    @Override
    protected Class<CertificatVariable> getEntityClass() {
        return CertificatVariable.class;
    }
}
