package com.medicoManager.settingsservice.mapper;

import com.medicoManager.settingsservice.dto.BilanDto;
import com.medicoManager.settingsservice.model.Bilan;
import org.springframework.stereotype.Service;


public abstract class AbstractBilanMapperService<E extends Bilan,D extends BilanDto> extends NameEntityMapperService<E, D> {



}
