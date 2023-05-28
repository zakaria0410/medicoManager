package com.medicoManager.settingsservice.mapper;

import com.medicoManager.settingsservice.dto.CertificatMedicalTypeDto;
import com.medicoManager.settingsservice.model.CertificatMedicalType;
import org.springframework.stereotype.Service;

@Service
public class CertificatMedicalTypeMapperService extends NameEntityMapperService<CertificatMedicalType, CertificatMedicalTypeDto> {
    @Override
    public CertificatMedicalType toEntity(CertificatMedicalTypeDto dto) {
        CertificatMedicalType m = super.toEntity(dto);
        m.setTitle(dto.getTitle());
        m.setParagraphe(dto.getParagraphe());
        return m;
    }

    @Override
    public CertificatMedicalTypeDto toDto(CertificatMedicalType entity) {
        CertificatMedicalTypeDto m = super.toDto(entity);
        //= super.toEntity(dto);
        m.setTitle(entity.getTitle());
        m.setParagraphe(entity.getParagraphe());

        return m;
    }

    @Override
    public CertificatMedicalTypeDto instanciateDto() {
        return new CertificatMedicalTypeDto();
    }

    @Override
    public CertificatMedicalType instanciateEntity() {
        return new CertificatMedicalType();
    }

    @Override
    protected Class<CertificatMedicalTypeDto> getDtoClass() {
        return CertificatMedicalTypeDto.class;
    }

    @Override
    protected Class<CertificatMedicalType> getEntityClass() {
        return CertificatMedicalType.class;
    }
}
