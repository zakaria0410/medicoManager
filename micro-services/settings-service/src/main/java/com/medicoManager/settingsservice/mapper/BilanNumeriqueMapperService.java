package com.medicoManager.settingsservice.mapper;

import com.medicoManager.settingsservice.dto.BilanDto;
import com.medicoManager.settingsservice.model.BilanNumerique;
import org.springframework.stereotype.Service;

@Service
public class BilanNumeriqueMapperService extends AbstractBilanMapperService<BilanNumerique> {


    @Override
    protected BilanDto instanciateDto() {
        return new BilanDto();
    }

    @Override
    protected BilanNumerique instanciateEntity() {
        return new BilanNumerique();
    }

    @Override
    protected Class<BilanDto> getDtoClass() {
        return BilanDto.class;
    }

    @Override
    protected Class<BilanNumerique> getEntityClass() {
        return BilanNumerique.class;
    }


    @Override
    public BilanNumerique toEntity(BilanDto dto) {

        BilanNumerique entity = super.toEntity(dto);
        entity.setValeur_max(dto.getValeur_max());
        entity.setValeur_min(dto.getValeur_min());
        entity.setUniteMesure(dto.getUniteMesure());
        return entity;

    }

    @Override
    public BilanDto toDto(BilanNumerique bilanNumerique) {
        BilanDto bilanDto = super.toDto(bilanNumerique);
        bilanDto.setNumerique(true);
        bilanDto.setValeur_max(bilanNumerique.getValeur_max());
        bilanDto.setValeur_min(bilanNumerique.getValeur_min());
        bilanDto.setUniteMesure(bilanNumerique.getUniteMesure());
        return bilanDto;
    }
}
