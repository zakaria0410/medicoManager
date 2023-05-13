package com.medicoManager.settingsservice.repository;

import com.medicoManager.settingsservice.dto.BilanDto;
import com.medicoManager.settingsservice.mapper.NameEntityMapperService;
import com.medicoManager.settingsservice.model.Bilan;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface AbstractBilanRepository<E extends Bilan> extends AbstractNameSettingsRepository<E> {
}

