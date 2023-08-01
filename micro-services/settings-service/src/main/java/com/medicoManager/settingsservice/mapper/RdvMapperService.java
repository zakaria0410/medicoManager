package com.medicoManager.settingsservice.mapper;

import com.medicoManager.settingsservice.dto.RdvDto;
import com.medicoManager.settingsservice.model.Rdv;
import com.medicoManager.settingsservice.workflows.rdv.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RdvMapperService extends BaseEntityMapperService<Rdv, RdvDto> {
    @Autowired
    private PatientMapperService patientMapperService;
    @Autowired
    private MedcinMapperService medcinMapperService;
    RdvState rdvState(String state) {
        RdvState rdvState = new RdvInitiationState();
        if(state!=null){
        switch (state) {
            case "annulé": {
                rdvState = new RdvAnnuleState();
                break;
            }
            case "confirmé": {
                rdvState = new RdvConfirmeState();
                break;
            }
            case "planifié": {
                rdvState = new RdvPlanifieState();
                break;
            }
            case "initié": {
                System.out.println("voilllaaaaaaa l'initiation");
                rdvState = new RdvInitiationState();
                break;
            }
            case "en consultation": {
                rdvState = new RdvMedecinEnCabinetState();
                break;
            }
            case "en cabinet": {
                rdvState = new RdvPatientEnCabinetState();
                break;
            }
            case "finalisé": {
                rdvState = new RdvFinaliseState();
                break;
            }
            default:
                System.out.println("ne trouve aucinn etat");
                break;
        }}
        return rdvState;
    }
    @Override
    public Rdv toEntity(RdvDto dto) {
        Rdv entity = super.toEntity(dto);
        entity.setDate(dto.getDate());
        entity.setHeure(dto.getHeure());
     entity.setStatut(dto.getStatut());
entity.setDateAnnulation(dto.getDateAnnulation());
entity.setDateConfirmation(dto.getDateConfirmation());
entity.setDateInitiation(dto.getDateInitiation());
entity.setDatePlanification(dto.getDatePlanification());
entity.setDateEnCabinet(dto.getDateEnCabinet());
entity.setDateConsultation(dto.getDateConsultation());
entity.setDateFinalisation(dto.getDateFinalisation());
entity.setSansRdv(dto.getSansRdv());
entity.setInitiationPatient(dto.getInitiationPatient());
entity.setMedcin(medcinMapperService.toEntity(dto.getMedcin()));
        entity.setPatient(patientMapperService.toEntity(dto.getPatient()));

        return entity;
    }

    @Override
    public RdvDto toDto(Rdv dto) {
        RdvDto entity = super.toDto(dto);
        entity.setDate(dto.getDate());
        entity.setHeure(dto.getHeure());
        entity.setStatut(dto.getStatut());
        entity.setRdvState(rdvState(dto.getStatut()));
        entity.setPatient(patientMapperService.toDto(dto.getPatient()));
        entity.setDateAnnulation(dto.getDateAnnulation());
        entity.setDateConfirmation(dto.getDateConfirmation());
        entity.setDateInitiation(dto.getDateInitiation());
        entity.setDatePlanification(dto.getDatePlanification());
        entity.setDateEnCabinet(dto.getDateEnCabinet());
        entity.setDateConsultation(dto.getDateConsultation());
        entity.setDateFinalisation(dto.getDateFinalisation());
        entity.setSansRdv(dto.getSansRdv());
        entity.setInitiationPatient(dto.getInitiationPatient());
        entity.setMedcin(medcinMapperService.toDto(dto.getMedcin()));
        return entity;
    }

    @Override
    public RdvDto instanciateDto() {
        return new RdvDto();
    }

    @Override
    public Rdv instanciateEntity() {
        return new Rdv();
    }

    @Override
    protected Class<RdvDto> getDtoClass() {
        return RdvDto.class;
    }

    @Override
    protected Class<Rdv> getEntityClass() {
        return Rdv.class;
    }
}
