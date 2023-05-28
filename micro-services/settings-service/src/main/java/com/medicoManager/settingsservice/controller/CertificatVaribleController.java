package com.medicoManager.settingsservice.controller;

import com.medicoManager.settingsservice.dto.CertificatVariableDto;
import com.medicoManager.settingsservice.model.CertificatVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/certificat-variable")
public class CertificatVaribleController extends AbstractNameSettingsController<CertificatVariable, CertificatVariableDto> {
}


