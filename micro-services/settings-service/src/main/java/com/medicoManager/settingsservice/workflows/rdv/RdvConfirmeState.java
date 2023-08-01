package com.medicoManager.settingsservice.workflows.rdv;

import com.medicoManager.settingsservice.dto.RdvDto;

import java.time.LocalDateTime;

public class RdvConfirmeState implements RdvState {
    @Override
    public String messageConfirmer(RdvDto rdvDto) {
        rdvDto.setDateEnCabinet(LocalDateTime.now());
        return "patient en cabinet";
    }

    @Override
    public String messageAnnulation(RdvDto rdvDto) {
        return "annuler confirmation";
    }
    @Override
    public void start(RdvDto rdv) {

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
    public void confirmer(RdvDto rdvDto) throws ImpossibleTransactionWorkflow {

        rdvDto.setStatut("en cabinet");
        rdvDto.setDateConfirmation(LocalDateTime.now());
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
    @Override
    public String bg() {
        return "bg-info";
    }
}

