package com.medicoManager.settingsservice.mapper;

import com.medicoManager.settingsservice.dto.ActeDto;
import com.medicoManager.settingsservice.dto.BilanTypeDto;
import com.medicoManager.settingsservice.model.Acte;
import com.medicoManager.settingsservice.model.BilanType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public  class ActeMapperService extends NameEntityMapperService<Acte, ActeDto> {
@Autowired
private MatierePremiereMapperService matierePremiereMapperService;
@Autowired
private DispositifMedicalMapperService dispositifMedicalMapperService;
    @Override
    public Acte toEntity(ActeDto dto) {
        Acte acte= super.toEntity(dto);
        acte.setCodification(dto.getCodification());
        acte.setPrix_unitaire(dto.getPrix_unitaire());
        acte.setMatieres(dto.getMatieres().stream().map(matierePremiereDto -> matierePremiereMapperService.toEntity(matierePremiereDto)).collect(Collectors.toList()));
        acte.setDispositifsMedicaux(dto.getDispositifsMedicaux().stream().map(dispositifMedicalDto -> dispositifMedicalMapperService.toEntity(dispositifMedicalDto)).collect(Collectors.toList()));
  return acte;    }

    @Override
    public ActeDto toDto(Acte acte) {
        ActeDto acteDto= super.toDto(acte);
        acteDto.setCodification(acte.getCodification());
        acteDto.setPrix_unitaire(acte.getPrix_unitaire());
        acteDto.setMatieres(acte.getMatieres().stream().map(matierePremiere -> matierePremiereMapperService.toDto(matierePremiere)).collect(Collectors.toList()));
        acteDto.setDispositifsMedicaux(acte.getDispositifsMedicaux().stream().map(dispositifMedical -> dispositifMedicalMapperService.toDto(dispositifMedical)).collect(Collectors.toList()));
    return acteDto;  }

    @Override
    public ActeDto instanciateDto() {
        return new ActeDto();
    }

    @Override
    public Acte instanciateEntity() {
        return new Acte();
    }

    @Override
    protected Class<ActeDto> getDtoClass() {
        return ActeDto.class;
    }

    @Override
    protected Class<Acte> getEntityClass() {
        return Acte.class;
    }
}
