package com.medicoManager.settingsservice.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.medicoManager.settingsservice.dto.VitalParameterDto;
import com.medicoManager.settingsservice.model.VitalParameter;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class VitalParameterService extends AbstractNameSettingsService<VitalParameter, VitalParameterDto> {
    @Override
    protected Class<VitalParameterDto> getDtoClass() {
        return VitalParameterDto.class;
    }
    @Override
    public List<VitalParameterDto> mapJsonToDto(MultipartFile file) {
        try {
            return new ObjectMapper().readValue(file.getInputStream(), new TypeReference<List<VitalParameterDto>>() {});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    protected Class<VitalParameter> getEntityClass() {
        return VitalParameter.class;
    }
}

