package com.medicoManager.settingsservice.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.medicoManager.settingsservice.dto.BilanDto;
import com.medicoManager.settingsservice.dto.BilanNumeriqueDto;
import com.medicoManager.settingsservice.dto.BilanTextuelDto;
import com.medicoManager.settingsservice.model.BilanNumerique;
import com.medicoManager.settingsservice.model.BilanTextuel;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class BilanNumeriqueService extends AbstractBilanService<BilanNumerique> {

    @Override
    protected Class<BilanDto> getDtoClass() {
        return BilanDto.class;
    }

    @Override
    protected Class<BilanNumerique> getEntityClass() {
        return BilanNumerique.class;
    }

    @Override
    public List<BilanDto> mapJsonToDto(MultipartFile file) {
        return null;
    }
}

