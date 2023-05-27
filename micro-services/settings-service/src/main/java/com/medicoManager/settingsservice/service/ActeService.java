package com.medicoManager.settingsservice.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.medicoManager.settingsservice.dto.ActeDto;
import com.medicoManager.settingsservice.mapper.DispositifMedicalMapperService;
import com.medicoManager.settingsservice.mapper.MatierePremiereMapperService;
import com.medicoManager.settingsservice.model.Acte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActeService extends AbstractNameSettingsService<Acte, ActeDto> {
    @Override
    protected Class<ActeDto> getDtoClass() {
        return ActeDto.class;
    }

    @Autowired
    private DispositifMedicalService dispositifMedicalService;
    @Autowired
    private DispositifMedicalMapperService dispositifMedicalMapperService;
    @Autowired
    private MatierePremiereService matierePremiereService;
    @Autowired
    private MatierePremiereMapperService matierePremiereMapperService;

    @Override
    public List<ActeDto> mapJsonToDto(MultipartFile file) {
        try {
            List<ActeDto> acteDtos = new ObjectMapper().readValue(file.getInputStream(), new TypeReference<List<ActeDto>>() {
            });
            return acteDtos.stream().map(acteDto -> {
                ActeDto acteDto1 = new ActeDto();
                acteDto1 = acteDto;
                acteDto1.setDispositifsMedicaux(acteDto.getDispositifs().stream().map(e -> dispositifMedicalService.getUniqueByNameOrCreate(e)).filter(e -> e != null).collect(Collectors.toList()));
                acteDto1.setMatieres(acteDto.getMatieress().stream().map(e -> matierePremiereService.getUniqueByNameOrCreate(e)).filter(e -> e != null).collect(Collectors.toList()));
                return acteDto1;
            }).collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    protected Class<Acte> getEntityClass() {
        return Acte.class;
    }
}

