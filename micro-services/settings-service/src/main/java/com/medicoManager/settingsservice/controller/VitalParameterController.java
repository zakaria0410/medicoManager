package com.medicoManager.settingsservice.controller;

import com.medicoManager.settingsservice.dto.VitalParameterDto;
import com.medicoManager.settingsservice.model.VitalParameter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/parametres-vitaux")
public class VitalParameterController extends AbstractNameSettingsController<VitalParameter, VitalParameterDto> {
}


