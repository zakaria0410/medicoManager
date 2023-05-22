package com.medicoManager.settingsservice.controller;

import com.medicoManager.settingsservice.dto.BilanDto;
import com.medicoManager.settingsservice.dto.MedicamentDto;
import com.medicoManager.settingsservice.model.Bilan;
import com.medicoManager.settingsservice.model.Medicament;
import com.medicoManager.settingsservice.service.BilanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bilan")
public class BilanController extends AbstractNameSettingsController<Bilan, BilanDto> {

    @Autowired
    private BilanService bilanService;
    @Override
    @RequestMapping("/save")
    public BilanDto create(@RequestBody BilanDto dto) {
        return bilanService.create(dto);
    }
}


