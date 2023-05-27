package com.medicoManager.settingsservice.controller;

import com.medicoManager.settingsservice.dto.BilanTypeDto;
import com.medicoManager.settingsservice.dto.OrdonanceTypeDto;
import com.medicoManager.settingsservice.model.BilanType;
import com.medicoManager.settingsservice.model.OrdonanceType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bilan-type")
public class BilanTypeController extends AbstractNameSettingsController<BilanType, BilanTypeDto> {
}


