package com.medicoManager.settingsservice.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.medicoManager.settingsservice.dto.BilanDto;
import com.medicoManager.settingsservice.dto.BilanTextuelDto;
import com.medicoManager.settingsservice.model.BilanTextuel;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class BilanTextuelService extends AbstractBilanService<BilanTextuel> {
    @Override
    protected Class<BilanDto> getDtoClass() {
        return BilanDto.class;
    }

    @Override
    protected Class<BilanTextuel> getEntityClass() {
        return BilanTextuel.class;
    }

    @Override
    public List<BilanDto> mapJsonToDto(MultipartFile file) {
     try {
            return new ObjectMapper().readValue(file.getInputStream(), new TypeReference<List<BilanDto>>() {});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    }

