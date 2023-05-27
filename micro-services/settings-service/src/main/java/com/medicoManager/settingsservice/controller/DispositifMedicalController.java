package com.medicoManager.settingsservice.controller;

import com.medicoManager.settingsservice.dto.DispositifMedicalDto;
import com.medicoManager.settingsservice.dto.MedicamentDto;
import com.medicoManager.settingsservice.model.DispositifMedical;
import com.medicoManager.settingsservice.model.Medicament;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dispositif-medical")
public class DispositifMedicalController extends AbstractNameSettingsController<DispositifMedical, DispositifMedicalDto> {
}


