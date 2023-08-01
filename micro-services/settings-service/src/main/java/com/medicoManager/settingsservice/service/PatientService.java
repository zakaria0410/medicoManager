package com.medicoManager.settingsservice.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import com.medicoManager.settingsservice.dto.OrdonanceTypeDto;
import com.medicoManager.settingsservice.dto.PatientDto;
import com.medicoManager.settingsservice.mapper.DispositifMedicalMapperService;
import com.medicoManager.settingsservice.mapper.MatierePremiereMapperService;
import com.medicoManager.settingsservice.mapper.PatientMapperService;
import com.medicoManager.settingsservice.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientService extends AbstractPersonneService<Patient, PatientDto> {
    @Override
    protected Class<PatientDto> getDtoClass() {
        return PatientDto.class;
    }
    @Override
    public List<PatientDto> mapJsonToDto(MultipartFile file) {
        try {
            return new ObjectMapper().readValue(file.getInputStream(), new TypeReference<List<PatientDto>>() {});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

@Autowired
private PatientMapperService patientMapperService;
    @Override
    protected Class<Patient> getEntityClass() {
        return Patient.class;
    }
    public List<PatientDto> generatePatients(int count) {
        List<Patient> patients = new ArrayList<>();
Faker faker=new Faker();
        for (int i = 0; i < count; i++) {
            Patient patient = new Patient();
            patient.setNom(faker.name().lastName());
            patient.setPrenom(faker.name().firstName());
            patient.setAdresse(faker.address().fullAddress());
            patient.setTelephone1(faker.phoneNumber().cellPhone());
            patient.setTelephone2(faker.phoneNumber().cellPhone());
            patient.setEmail(faker.internet().emailAddress());
            patient.setCivilite(faker.demographic().sex());
            patient.setCin(new Faker().number().digits(13));
            patient.setNCnss(new Faker().number().digits(13));
            patient.setMutuelle(faker.company().name());
            patient.setNMutuelle(new Faker().number().digits(13));
            patient.setNumeroSecuriteSociale(new Faker().number().digits(13));
            // Définissez les autres attributs du patient en utilisant les méthodes de la classe Faker

            patients.add(patient);
        }
saveAll(patients.stream().map(patient -> patientMapperService.toDto(patient)).collect(Collectors.toList()));
        return patients.stream().map(patient -> patientMapperService.toDto(patient)).collect(Collectors.toList());
    }
}

