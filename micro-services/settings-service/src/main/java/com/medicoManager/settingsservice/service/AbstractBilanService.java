package com.medicoManager.settingsservice.service;

import com.medicoManager.settingsservice.dto.BilanDto;
import com.medicoManager.settingsservice.model.Bilan;
import org.springframework.stereotype.Service;


public abstract class AbstractBilanService<E extends Bilan> extends AbstractNameSettingsService<E, BilanDto> {
}

