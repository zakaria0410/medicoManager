package com.medicoManager.settingsservice.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.medicoManager.settingsservice.dto.BilanTypeDto;
import com.medicoManager.settingsservice.dto.DispositifMedicalDto;
import com.medicoManager.settingsservice.model.BilanType;
import com.medicoManager.settingsservice.model.DispositifMedical;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class DispositifMedicalService extends AbstractNameSettingsService<DispositifMedical, DispositifMedicalDto> {
    @Override
    protected Class<DispositifMedicalDto> getDtoClass() {
        return DispositifMedicalDto.class;
    }
    @Override
    public List<DispositifMedicalDto> mapJsonToDto(MultipartFile file) {
        try {
            return new ObjectMapper().readValue(file.getInputStream(), new TypeReference<List<DispositifMedicalDto>>() {});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    protected Class<DispositifMedical> getEntityClass() {
        return DispositifMedical.class;
    }
}

