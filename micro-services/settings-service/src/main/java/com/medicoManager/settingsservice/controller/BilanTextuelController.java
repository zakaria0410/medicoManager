package com.medicoManager.settingsservice.controller;

import com.medicoManager.settingsservice.dto.BilanDto;
import com.medicoManager.settingsservice.dto.BilanTextuelDto;
import com.medicoManager.settingsservice.model.Bilan;
import com.medicoManager.settingsservice.model.BilanTextuel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bilan/texte")
public class BilanTextuelController extends AbstractBilanController<BilanTextuel> {
}


