package com.medicoManager.settingsservice.mapper;

import com.medicoManager.settingsservice.dto.PatientDto;
import com.medicoManager.settingsservice.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public  class PatientMapperService extends PersonEntityMapperService<Patient, PatientDto> {
@Autowired
private BilanMapperService bilanMapperService;
    @Override
    public Patient toEntity(PatientDto dto) {
        Patient patient= super.toEntity(dto);
       patient.setAccesApplication(dto.isAccesApplication());
       patient.setAntecedentsCliniques(dto.getAntecedentsCliniques());
       patient.setAntecedentsChirurgicaux(dto.getAntecedentsChirurgicaux());
       patient.setGroupeSanguin(dto.getGroupeSanguin());
       patient.setMutuelle(dto.getMutuelle());
       patient.setNMutuelle(dto.getNMutuelle());
       patient.setNumeroSecuriteSociale(dto.getNumeroSecuriteSociale());
       patient.setNumeroTelephoneUrgence(dto.getNumeroTelephoneUrgence());
       patient.setCin(dto.getCin());
       patient.setNCnss(dto.getNCnss());
        return patient;    }

    @Override
    public PatientDto toDto(Patient dto) {
        PatientDto patient= super.toDto(dto);
        patient.setAccesApplication(dto.isAccesApplication());
        patient.setAntecedentsCliniques(dto.getAntecedentsCliniques());
        patient.setAntecedentsChirurgicaux(dto.getAntecedentsChirurgicaux());
        patient.setGroupeSanguin(dto.getGroupeSanguin());
        patient.setMutuelle(dto.getMutuelle());
        patient.setNMutuelle(dto.getNMutuelle());
        patient.setNumeroSecuriteSociale(dto.getNumeroSecuriteSociale());
        patient.setNumeroTelephoneUrgence(dto.getNumeroTelephoneUrgence());
        patient.setNCnss(dto.getNCnss());

        patient.setCin(dto.getCin());
        return patient;
    //    return super.toDto(patient);
    }

    @Override
    public PatientDto instanciateDto() {
        return new PatientDto();
    }

    @Override
    public Patient instanciateEntity() {
        return new Patient();
    }

    @Override
    protected Class<PatientDto> getDtoClass() {
        return PatientDto.class;
    }

    @Override
    protected Class<Patient> getEntityClass() {
        return Patient.class;
    }
}
