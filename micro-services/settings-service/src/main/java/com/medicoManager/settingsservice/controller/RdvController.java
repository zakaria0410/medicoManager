package com.medicoManager.settingsservice.controller;

import com.medicoManager.settingsservice.dto.RdvDto;
import com.medicoManager.settingsservice.model.Rdv;
import com.medicoManager.settingsservice.service.RdvService;
import com.medicoManager.settingsservice.workflows.rdv.ImpossibleTransactionWorkflow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/rdv")
public class RdvController extends BaseEntityController<Rdv, RdvDto> {

    @Autowired
    private RdvService rdvService;
    @PostMapping ("/confirmer")
    public RdvDto doWorkFlowRdv(@RequestBody RdvDto rdvDto) throws ImpossibleTransactionWorkflow {
        return rdvService.confirmer(rdvDto);
    }
    @PostMapping("/annuler")
    public RdvDto annulerWorkFlowRdv(@RequestBody RdvDto rdvDto) throws Exception, ImpossibleTransactionWorkflow {
        return rdvService.annuler(rdvDto);
    }
    @GetMapping("/distinct-date")
    public HashMap<LocalDate, HashMap<String, List<RdvDto>>> datesDistinct(){
        return rdvService.distinctDates();
    }
    @GetMapping("/today/{statut}")
    public List<RdvDto> rdvToday(@PathVariable("statut") String statut){
        return rdvService.rdvToday(statut);
    }
    @GetMapping("/today/all")
    public List<RdvDto> rdvTodayAll(){
        return rdvService.rdvTodayAllStatus();
    }
}


