package com.medicoManager.settingsservice.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import com.medicoManager.settingsservice.dto.MedcinDto;
import com.medicoManager.settingsservice.mapper.MedcinMapperService;
import com.medicoManager.settingsservice.model.Medcin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedcinService extends AbstractPersonneService<Medcin, MedcinDto> {
    @Override
    protected Class<MedcinDto> getDtoClass() {
        return MedcinDto.class;
    }
    @Override
    public List<MedcinDto> mapJsonToDto(MultipartFile file) {
        try {
            return new ObjectMapper().readValue(file.getInputStream(), new TypeReference<List<MedcinDto>>() {});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

@Autowired
private MedcinMapperService patientMapperService;
    @Override
    protected Class<Medcin> getEntityClass() {
        return Medcin.class;
    }

}

