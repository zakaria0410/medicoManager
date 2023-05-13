package com.medicoManager.settingsservice.service;

import com.medicoManager.settingsservice.dto.BilanDto;
import com.medicoManager.settingsservice.model.Bilan;
import org.springframework.stereotype.Service;


public class AbstractBilanService<E extends Bilan,D extends BilanDto> extends AbstractNameSettingsService<E, D> {
}

