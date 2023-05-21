package com.medicoManager.settingsservice.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.medicoManager.settingsservice.dto.MedicamentDto;
import com.medicoManager.settingsservice.dto.OrdonanceTypeDto;
import com.medicoManager.settingsservice.model.Medicament;
import com.medicoManager.settingsservice.model.OrdonanceType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class OrdonanceTypeService extends AbstractNameSettingsService<OrdonanceType, OrdonanceTypeDto> {
    @Override
    protected Class<OrdonanceTypeDto> getDtoClass() {
        return OrdonanceTypeDto.class;
    }
    @Override
    public List<OrdonanceTypeDto> mapJsonToDto(MultipartFile file) {
        try {
            return new ObjectMapper().readValue(file.getInputStream(), new TypeReference<List<OrdonanceTypeDto>>() {});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    protected Class<OrdonanceType> getEntityClass() {
        return OrdonanceType.class;
    }
}

