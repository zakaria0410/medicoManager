package com.medicoManager.settingsservice.controller;

import com.medicoManager.settingsservice.dto.MatierePremiereDto;
import com.medicoManager.settingsservice.dto.MedicamentDto;
import com.medicoManager.settingsservice.model.MatierePremiere;
import com.medicoManager.settingsservice.model.Medicament;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/matiere-premiere")
public class MatierePremiereController extends AbstractNameSettingsController<MatierePremiere, MatierePremiereDto> {
}


