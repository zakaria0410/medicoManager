package com.medicoManager.settingsservice.controller;

import com.medicoManager.settingsservice.docUtils.certificats.dto.CertificatMedicalDocPresentation;
import com.medicoManager.settingsservice.dto.CertificatMedicalTypeDto;
import com.medicoManager.settingsservice.model.CertificatMedicalType;
import com.medicoManager.settingsservice.service.CertificatMedicalTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/certificat-medical-type")
public class CertificatMedicalTypeController extends AbstractNameSettingsController<CertificatMedicalType, CertificatMedicalTypeDto> {
@Autowired
private CertificatMedicalTypeService certificatMedicalTypeService;
@GetMapping("/variables/{id}")
    public CertificatMedicalDocPresentation variable(@PathVariable Long id) throws Exception {
    CertificatMedicalTypeDto certificatMedicalTypeDto=certificatMedicalTypeService.getById(id);
    if(certificatMedicalTypeDto!=null){
        return certificatMedicalTypeService.certificatMedicalDocPresentationFromOrdonanceType(certificatMedicalTypeDto);
    }else{
        return null;
    }
}
}


