package com.medicoManager.settingsservice.mapper;

import com.medicoManager.settingsservice.dto.BilanDto;
import com.medicoManager.settingsservice.dto.BilanTextuelDto;
import com.medicoManager.settingsservice.model.Bilan;
import com.medicoManager.settingsservice.model.BilanNumerique;
import com.medicoManager.settingsservice.model.BilanTextuel;
import org.springframework.stereotype.Service;

@Service
public  class BilanTextuelMapperService extends AbstractBilanMapperService<BilanTextuel> {


    @Override
    public BilanTextuelDto instanciateDto() {
        return new BilanTextuelDto();
    }

    @Override
    public BilanTextuel instanciateEntity() {
        return new BilanTextuel();
    }
    @Override
    public BilanTextuel toEntity(BilanDto dto) {

        BilanTextuel entity = super.toEntity(dto);
        entity.setResultatTextuel(dto.getResultatTextuel());
       // entity.setValeur_min(dto.getValeur_min());
        return entity;

    }

    @Override
    public BilanDto toDto(BilanTextuel bilanNumerique) {
        BilanDto bilanDto = super.toDto(bilanNumerique);
        bilanDto.setNumerique(false);
        bilanDto.setResultatTextuel(bilanNumerique.getResultatTextuel());
      //  bilanDto.setValeur_min(bilanDto.getValeur_min());
        return bilanDto;
    }
    @Override
    public Class<BilanDto> getDtoClass() {
        return BilanDto.class;
    }

    @Override
    public Class<BilanTextuel> getEntityClass() {
        return BilanTextuel.class;
    }
}
