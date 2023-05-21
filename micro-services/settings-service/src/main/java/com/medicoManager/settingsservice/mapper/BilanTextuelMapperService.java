package com.medicoManager.settingsservice.mapper;

import com.medicoManager.settingsservice.dto.BilanDto;
import com.medicoManager.settingsservice.dto.BilanTextuelDto;
import com.medicoManager.settingsservice.model.Bilan;
import com.medicoManager.settingsservice.model.BilanTextuel;
import org.springframework.stereotype.Service;

@Service
public  class BilanTextuelMapperService extends AbstractBilanMapperService<BilanTextuel, BilanTextuelDto> {


    @Override
    protected BilanTextuelDto instanciateDto() {
        return new BilanTextuelDto();
    }

    @Override
    protected BilanTextuel instanciateEntity() {
        return new BilanTextuel();
    }

    @Override
    protected Class<BilanTextuelDto> getDtoClass() {
        return BilanTextuelDto.class;
    }

    @Override
    protected Class<BilanTextuel> getEntityClass() {
        return BilanTextuel.class;
    }
}
