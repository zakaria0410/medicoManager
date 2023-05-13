package com.medicoManager.settingsservice.controller;

import com.medicoManager.settingsservice.dto.BilanNumeriqueDto;
import com.medicoManager.settingsservice.dto.BilanTextuelDto;
import com.medicoManager.settingsservice.model.BilanNumerique;
import com.medicoManager.settingsservice.model.BilanTextuel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bilan/numerique")
public class BilanNumeriqueController extends AbstractBilanController<BilanNumerique, BilanNumeriqueDto> {
}


