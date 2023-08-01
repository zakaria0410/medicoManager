package com.medicoManager.settingsservice.controller;

import com.medicoManager.settingsservice.dto.BilanDto;
import com.medicoManager.settingsservice.dto.PatientDto;
import com.medicoManager.settingsservice.model.Bilan;
import com.medicoManager.settingsservice.model.Patient;
import com.medicoManager.settingsservice.service.BilanService;
import com.medicoManager.settingsservice.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/patient")
public class PatientController extends AbstractPersonneController<Patient, PatientDto> {
    @Autowired
    private PatientService patientService;
    @GetMapping("/generate-patients")
    public List<PatientDto> generatePatients() {
        return patientService.generatePatients(100);
    }

}


