package com.medicoManager.settingsservice.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.medicoManager.settingsservice.dto.BilanTypeDto;
import com.medicoManager.settingsservice.dto.OrdonanceTypeDto;
import com.medicoManager.settingsservice.model.BilanType;
import com.medicoManager.settingsservice.model.OrdonanceType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class BilanTypeService extends AbstractNameSettingsService<BilanType, BilanTypeDto> {
    @Override
    protected Class<BilanTypeDto> getDtoClass() {
        return BilanTypeDto.class;
    }
    @Override
    public List<BilanTypeDto> mapJsonToDto(MultipartFile file) {
        try {
            return new ObjectMapper().readValue(file.getInputStream(), new TypeReference<List<BilanTypeDto>>() {});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    protected Class<BilanType> getEntityClass() {
        return BilanType.class;
    }
}

