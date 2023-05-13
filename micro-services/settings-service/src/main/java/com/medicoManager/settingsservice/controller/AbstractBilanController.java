package com.medicoManager.settingsservice.controller;

import com.medicoManager.settingsservice.dto.BilanDto;
import com.medicoManager.settingsservice.model.Bilan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


public class AbstractBilanController<E extends  Bilan,D extends BilanDto> extends AbstractNameSettingsController<E, D> {
}


