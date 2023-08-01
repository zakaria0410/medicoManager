package com.medicoManager.settingsservice.workflows.rdv;

import com.medicoManager.settingsservice.dto.RdvDto;
import com.medicoManager.settingsservice.model.Rdv;

public class RdvAnnuleState implements RdvState{


    @Override
    public void start(RdvDto rdv) {

    }

    @Override
    public void confirmer(RdvDto rdvDto) throws ImpossibleTransactionWorkflow {
        throw new ImpossibleTransactionWorkflow("on ne peut pas confrimer un rdv annulé");
    }

    @Override
    public String messageConfirmer(RdvDto rdvDto) {
        return null;
    }

    @Override
    public String messageAnnulation(RdvDto rdvDto) {
        return null;
    }

    @Override
    public void annuler(RdvDto rdvDto) throws ImpossibleTransactionWorkflow {
        throw new ImpossibleTransactionWorkflow("déjà annulé");
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
    public String statusName() {
        return "annulé";
    }

    @Override
    public String bg() {
        return "bg-danger";
    }
}
