package com.medicoManager.settingsservice.mapper;

import com.medicoManager.settingsservice.dto.BilanDto;
import com.medicoManager.settingsservice.dto.MedicamentDto;
import com.medicoManager.settingsservice.model.Bilan;
import com.medicoManager.settingsservice.model.Medicament;
import org.springframework.stereotype.Service;

@Service
public  class BilanMapperService extends NameEntityMapperService<Bilan, BilanDto> {


    @Override
    public Bilan toEntity(BilanDto dto) {
        Bilan entity= super.toEntity(dto);
        entity.setCodification(dto.getCodification());
return entity;
    }

    @Override
    public BilanDto toDto(Bilan bilan) {
        BilanDto bilanDto= super.toDto(bilan);
        bilanDto.setCodification(bilan.getCodification());
        return bilanDto;
    }

    @Override
    public BilanDto instanciateDto() {
         return new BilanDto();
    }

    @Override
    public Bilan instanciateEntity() {
         return new Bilan();
    }

    @Override
    protected Class<BilanDto> getDtoClass() {
        return BilanDto.class;
    }

    @Override
    protected Class<Bilan> getEntityClass() {
        return Bilan.class;
    }
}
