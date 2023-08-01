package com.medicoManager.settingsservice.workflows.rdv;

import com.medicoManager.settingsservice.dto.RdvDto;
import com.medicoManager.settingsservice.model.Rdv;

import java.time.LocalDateTime;

public class RdvPatientEnCabinetState implements RdvState {
    @Override
    public String messageConfirmer(RdvDto rdvDto) {
        return "en consultation";
    }
    @Override
    public String bg() {
        return "bg-success";
    }
    @Override
    public String messageAnnulation(RdvDto rdvDto) {
        return null;
    }
    @Override
    public boolean toConfirm() {
        return true;
    }

    @Override
    public boolean toDiscard() {
        return false;
    }
    @Override
    public void start(RdvDto rdv) {
        rdv.setStatut("en cabinet");
        rdv.setDateEnCabinet(LocalDateTime.now());

    } @Override
    public void confirmer(RdvDto rdvDto) throws ImpossibleTransactionWorkflow {
        rdvDto.setStatut("en consultation");
        rdvDto.setDateConsultation(LocalDateTime.now());
    }

    @Override
    public void annuler(RdvDto rdvDto) throws ImpossibleTransactionWorkflow {
        throw new ImpossibleTransactionWorkflow("patient est present en cabinet");
    }

    @Override
    public String statusName() {
        return "en consultation";
    }
}
