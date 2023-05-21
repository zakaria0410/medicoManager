package com.medicoManager.settingsservice.mapper;

import com.medicoManager.settingsservice.dto.BilanNumeriqueDto;
import com.medicoManager.settingsservice.model.BilanNumerique;
import org.springframework.stereotype.Service;

@Service
public  class BilanNumeriqueMapperService extends AbstractBilanMapperService<BilanNumerique, BilanNumeriqueDto> {


    @Override
    protected BilanNumeriqueDto instanciateDto() {
        return new BilanNumeriqueDto();
    }

    @Override
    protected BilanNumerique instanciateEntity() {
        return new BilanNumerique();
    }

    @Override
    protected Class<BilanNumeriqueDto> getDtoClass() {
        return BilanNumeriqueDto.class;
    }

    @Override
    protected Class<BilanNumerique> getEntityClass() {
        return BilanNumerique.class;
    }
}
