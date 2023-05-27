package com.medicoManager.settingsservice.controller;

import com.medicoManager.settingsservice.dto.ActeDto;
import com.medicoManager.settingsservice.dto.MedicamentDto;
import com.medicoManager.settingsservice.model.Acte;
import com.medicoManager.settingsservice.model.Medicament;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/acte")
public class ActeController extends AbstractNameSettingsController<Acte, ActeDto> {
}


