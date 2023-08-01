package com.medicoManager.settingsservice.workflows.rdv;

import com.medicoManager.settingsservice.dto.RdvDto;
import com.medicoManager.settingsservice.model.Rdv;

import java.time.LocalDateTime;

public class RdvMedecinEnCabinetState implements RdvState {
    @Override
    public String messageConfirmer(RdvDto rdvDto) {

        return "Finaliser";
    }
    @Override
    public String bg() {
        return "bg-warning";
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

    }
    @Override
    public void confirmer(RdvDto rdvDto) throws ImpossibleTransactionWorkflow {
        rdvDto.setDateFinalisation(LocalDateTime.now());
        rdvDto.setStatut("finalisé");
    }

    @Override
    public void annuler(RdvDto rdvDto) throws ImpossibleTransactionWorkflow {
      throw new ImpossibleTransactionWorkflow("déjà en cabinet");
    }

    @Override
    public String statusName() {
        return "en consultation";
    }
}
