package com.medicoManager.settingsservice.mapper;

import com.medicoManager.settingsservice.dto.MedcinDto;
import com.medicoManager.settingsservice.dto.MedcinDto;
import com.medicoManager.settingsservice.model.Medcin;
import com.medicoManager.settingsservice.model.Medcin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public  class MedcinMapperService extends UserEntityMapperService<Medcin, MedcinDto> {
@Autowired
private BilanMapperService bilanMapperService;
    @Override
    public Medcin toEntity(MedcinDto dto) {
        Medcin medcin= super.toEntity(dto);
      medcin.setNordre(dto.getNordre());
      medcin.setSpecialite(dto.getSpecialite());
        return medcin;    }

    @Override
    public MedcinDto toDto(Medcin dto) {
        MedcinDto medcin= super.toDto(dto);
        medcin.setNordre(dto.getNordre());
        medcin.setSpecialite(dto.getSpecialite());
        return medcin;
    //    return super.toDto(patient);
    }

    @Override
    public MedcinDto instanciateDto() {
        return new MedcinDto();
    }

    @Override
    public Medcin instanciateEntity() {
        return new Medcin();
    }

    @Override
    protected Class<MedcinDto> getDtoClass() {
        return MedcinDto.class;
    }

    @Override
    protected Class<Medcin> getEntityClass() {
        return Medcin.class;
    }
}
