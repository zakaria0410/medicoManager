package com.medicoManager.settingsservice.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.medicoManager.settingsservice.dto.RdvDto;
import com.medicoManager.settingsservice.mapper.DispositifMedicalMapperService;
import com.medicoManager.settingsservice.mapper.MatierePremiereMapperService;
import com.medicoManager.settingsservice.mapper.RdvMapperService;
import com.medicoManager.settingsservice.model.Rdv;
import com.medicoManager.settingsservice.repository.RdvRepository;
import com.medicoManager.settingsservice.workflows.rdv.ImpossibleTransactionWorkflow;
import com.medicoManager.settingsservice.workflows.rdv.RdvInitiationState;
import com.medicoManager.settingsservice.workflows.rdv.RdvPatientEnCabinetState;
import com.medicoManager.settingsservice.workflows.rdv.RdvPlanifieState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RdvService extends BaseService<Rdv, RdvDto> {
    @Override
    protected Class<RdvDto> getDtoClass() {
        return RdvDto.class;
    }

    @Autowired
    private RdvMapperService rdvMapperService;
    @Autowired
    private DispositifMedicalService dispositifMedicalService;
    @Autowired
    private DispositifMedicalMapperService dispositifMedicalMapperService;
    @Autowired
    private MatierePremiereService matierePremiereService;
    @Autowired
    private MatierePremiereMapperService matierePremiereMapperService;
    @Autowired
    private RdvRepository rdvRepository;

    @Override
    public List<RdvDto> mapJsonToDto(MultipartFile file) {
        try {
            return new ObjectMapper().readValue(file.getInputStream(), new TypeReference<List<RdvDto>>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    protected Class<Rdv> getEntityClass() {
        return Rdv.class;
    }


    @Override
    public RdvDto create(RdvDto dto) {
        if (dto.getId() == null) {
            if(!dto.getSansRdv()) {
                if (dto.getInitiationPatient()) dto.setStatut("initié");
                else{
                    dto.setStatut("planifié");
                }}else{
              dto.setStatut("en cabinet");
            }
       }
        dto.start();
        return super.create(dto);
    }

    public RdvDto confirmer(RdvDto rdvDto) throws ImpossibleTransactionWorkflow {
        rdvDto.start();
        rdvDto.confirmer();
        return create(rdvDto);

    }


    public RdvDto annuler(RdvDto rdvDto) throws ImpossibleTransactionWorkflow {
        rdvDto.start();
        rdvDto.annuler();

        return create(rdvDto);

    }

    public HashMap<LocalDate, HashMap<String, List<RdvDto>>> distinctDates() {
        HashMap<LocalDate, HashMap<String, List<RdvDto>>> hashMap = new HashMap<>();

        rdvRepository.DistinctsDatesOfRdvs().stream().forEach(
                date -> {
                    HashMap<String, List<RdvDto>> subhashMap = new HashMap<>();
                    rdvRepository.DistinctsHoursOfDate(date).stream().forEach(
                            heure -> {
                                subhashMap.put(heure, rdvRepository.findByDateAndHeure(date, heure).stream().map(rdv ->rdvMapperService.toDto(rdv)).collect(Collectors.toList()));
                            }
                    );
              hashMap.put(date,subhashMap);  }
        );
        return hashMap;
    }

    public List<RdvDto> rdvToday(String statut){
        return rdvRepository.findByDateAndStatut(LocalDate.now(),statut).stream().map(rdv -> rdvMapperService.toDto(rdv)).collect(Collectors.toList());
    }
    public List<RdvDto> rdvTodayAllStatus(){
        return rdvRepository.findByDate(LocalDate.now()).stream().map(rdv -> rdvMapperService.toDto(rdv)).collect(Collectors.toList());
    }
}

