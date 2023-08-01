package com.medicoManager.settingsservice.workflows.rdv;

import com.medicoManager.settingsservice.dto.RdvDto;
import com.medicoManager.settingsservice.model.Rdv;

public interface RdvState {
void start(RdvDto rdv);
    void confirmer(RdvDto rdvDto) throws ImpossibleTransactionWorkflow;
    String messageConfirmer(RdvDto rdvDto);
    String messageAnnulation(RdvDto rdvDto);
    void annuler(RdvDto rdvDto) throws ImpossibleTransactionWorkflow;
boolean toConfirm();
boolean toDiscard();
    String statusName();
    String bg();
}
