package com.medicoManager.settingsservice.workflows.rdv;

import com.medicoManager.settingsservice.dto.RdvDto;
import com.medicoManager.settingsservice.model.Rdv;

public class RdvFinaliseState implements RdvState {
    @Override
    public String messageConfirmer(RdvDto rdvDto) {
        return null;
    }

    @Override
    public String messageAnnulation(RdvDto rdvDto) {
        return null;
    }
    @Override
    public void start(RdvDto rdv) {

    }
    @Override
    public boolean toConfirm() {
        return false;
    }

    @Override
    public boolean toDiscard() {
        return false;
    }
    @Override
    public void confirmer(RdvDto rdvDto) throws ImpossibleTransactionWorkflow {

     throw  new ImpossibleTransactionWorkflow("ce rdv est déjà finalisé");
    }

    @Override
    public void annuler(RdvDto rdvDto) throws ImpossibleTransactionWorkflow {
        throw  new ImpossibleTransactionWorkflow("ce rdv est déjà finalisé");
    }

    @Override
    public String statusName() {
        return null;
    }
    @Override
    public String bg() {
        return "bg-success";
    }
}

