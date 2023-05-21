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
public class BilanTextuelService extends AbstractBilanService<BilanTextuel, BilanTextuelDto> {
    @Override
    protected Class<BilanTextuelDto> getDtoClass() {
        return BilanTextuelDto.class;
    }

    @Override
    protected Class<BilanTextuel> getEntityClass() {
        return BilanTextuel.class;
    }

    @Override
    public List<BilanTextuelDto> mapJsonToDto(MultipartFile file) {
     try {
            return new ObjectMapper().readValue(file.getInputStream(), new TypeReference<List<BilanTextuelDto>>() {});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    }

