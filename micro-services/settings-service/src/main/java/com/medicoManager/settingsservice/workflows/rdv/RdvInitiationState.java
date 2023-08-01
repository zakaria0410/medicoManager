package com.medicoManager.settingsservice.workflows.rdv;

import com.medicoManager.settingsservice.dto.RdvDto;

import java.time.LocalDateTime;

public class RdvInitiationState implements RdvState {
    @Override
    public String bg() {
        return "bg-primary";
    }

    @Override
    public String messageConfirmer(RdvDto rdvDto) {


        return "planifier rdv";
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
        rdv.setDateInitiation(LocalDateTime.now());
        rdv.setStatut("initié");
    }

    @Override
    public void confirmer(RdvDto rdvDto) throws ImpossibleTransactionWorkflow {
        rdvDto.setDateConfirmation(LocalDateTime.now());
        rdvDto.setStatut("planifié");
    }

    @Override
    public void annuler(RdvDto rdvDto) throws ImpossibleTransactionWorkflow {
        rdvDto.setDateAnnulation(LocalDateTime.now());
        rdvDto.setStatut("annulé");
    }

    @Override
    public String statusName() {
        return null;
    }
}

