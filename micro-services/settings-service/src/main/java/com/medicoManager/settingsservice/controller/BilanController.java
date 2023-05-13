package com.medicoManager.settingsservice.controller;

import com.medicoManager.settingsservice.dto.BilanDto;
import com.medicoManager.settingsservice.dto.MedicamentDto;
import com.medicoManager.settingsservice.model.Bilan;
import com.medicoManager.settingsservice.model.Medicament;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bilan")
public class BilanController extends AbstractNameSettingsController<Bilan, BilanDto> {
}


