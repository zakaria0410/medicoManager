package com.medicoManager.settingsservice.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.medicoManager.settingsservice.dto.DispositifMedicalDto;
import com.medicoManager.settingsservice.dto.MatierePremiereDto;
import com.medicoManager.settingsservice.model.DispositifMedical;
import com.medicoManager.settingsservice.model.MatierePremiere;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class MatierePremiereService extends AbstractNameSettingsService<MatierePremiere, MatierePremiereDto> {
    @Override
    protected Class<MatierePremiereDto> getDtoClass() {
        return MatierePremiereDto.class;
    }
    @Override
    public List<MatierePremiereDto> mapJsonToDto(MultipartFile file) {
        try {
            return new ObjectMapper().readValue(file.getInputStream(), new TypeReference<List<MatierePremiereDto>>() {});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    protected Class<MatierePremiere> getEntityClass() {
        return MatierePremiere.class;
    }
}

