package com.medicoManager.settingsservice.controller;

import com.medicoManager.settingsservice.dto.MedicamentDto;
import com.medicoManager.settingsservice.dto.OrdonanceTypeDto;
import com.medicoManager.settingsservice.model.Medicament;
import com.medicoManager.settingsservice.model.OrdonanceType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ordonance-type")
public class OrdonanceTypeController extends AbstractNameSettingsController<OrdonanceType, OrdonanceTypeDto> {
}


