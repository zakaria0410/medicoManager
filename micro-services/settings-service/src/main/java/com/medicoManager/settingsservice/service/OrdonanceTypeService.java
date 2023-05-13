package com.medicoManager.settingsservice.service;

import com.medicoManager.settingsservice.dto.MedicamentDto;
import com.medicoManager.settingsservice.dto.OrdonanceTypeDto;
import com.medicoManager.settingsservice.model.Medicament;
import com.medicoManager.settingsservice.model.OrdonanceType;
import org.springframework.stereotype.Service;

@Service
public class OrdonanceTypeService extends AbstractNameSettingsService<OrdonanceType, OrdonanceTypeDto> {
}

