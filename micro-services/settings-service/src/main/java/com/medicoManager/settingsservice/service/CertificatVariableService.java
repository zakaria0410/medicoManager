package com.medicoManager.settingsservice.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.medicoManager.settingsservice.dto.CertificatVariableDto;
import com.medicoManager.settingsservice.model.CertificatVariable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class CertificatVariableService extends AbstractNameSettingsService<CertificatVariable, CertificatVariableDto> {
    @Override
    protected Class<CertificatVariableDto> getDtoClass() {
        return CertificatVariableDto.class;
    }
    @Override
    public List<CertificatVariableDto> mapJsonToDto(MultipartFile file) {
        try {
            return new ObjectMapper().readValue(file.getInputStream(), new TypeReference<List<CertificatVariableDto>>() {});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    protected Class<CertificatVariable> getEntityClass() {
        return CertificatVariable.class;
    }
}

