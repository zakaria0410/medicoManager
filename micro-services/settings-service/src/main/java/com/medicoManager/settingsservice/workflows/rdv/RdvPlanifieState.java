package com.medicoManager.settingsservice.workflows.rdv;

import com.medicoManager.settingsservice.dto.RdvDto;

import java.time.LocalDateTime;

public class RdvPlanifieState implements RdvState {
    @Override
    public String bg() {
        return "bg-info";
    }

    @Override
    public String messageConfirmer(RdvDto rdvDto) {
        return "confirmer rdv";
    }

    @Override
    public String messageAnnulation(RdvDto rdvDto) {
        return "annuler rdv";
    }

    @Override
    public boolean toConfirm() {
        return true;
    }

    @Override
    public boolean toDiscard() {
        return true;
    }

    @Override
    public void start(RdvDto rdv) {
        rdv.setDatePlanification(LocalDateTime.now());
        rdv.setStatut("planifié");
    }

    @Override
    public void confirmer(RdvDto rdvDto) throws ImpossibleTransactionWorkflow {
        rdvDto.setDateEnCabinet(LocalDateTime.now());
        rdvDto.setStatut("confirmé");
    }

    @Override
    public void annuler(RdvDto rdvDto) throws ImpossibleTransactionWorkflow {
        rdvDto.setDateAnnulation(LocalDateTime.now());
        rdvDto.setStatut("annulé");
    }

    @Override
    public String statusName() {
        return "en consultation";
    }
}
