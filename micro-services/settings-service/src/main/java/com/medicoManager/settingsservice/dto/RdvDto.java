package com.medicoManager.settingsservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.medicoManager.settingsservice.workflows.rdv.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;


public class RdvDto extends BaseDTO {


    private PatientDto patient;

private MedcinDto medcin;
    private LocalDate date;

    private String heure;

    private boolean toconfirm;
    private boolean todiscard;
    private String messageConfirmation;
    private String messageAnnulation;
    private String bg;
    private LocalDateTime dateInitiation;

    private LocalDateTime datePlanification;


    private LocalDateTime dateConfirmation;

    private LocalDateTime dateAnnulation;

    private LocalDateTime dateEnCabinet;
    private LocalDateTime dateConsultation;
    private LocalDateTime dateFinalisation;
    private boolean sansRdv;
    private boolean initiationPatient;

    public LocalDateTime getDateInitiation() {
        return dateInitiation;
    }

    public MedcinDto getMedcin() {
        return medcin;
    }

    public void setMedcin(MedcinDto medcin) {
        this.medcin = medcin;
    }

    public void setDateInitiation(LocalDateTime dateInitiation) {
        this.dateInitiation = dateInitiation;
    }

    public LocalDateTime getDatePlanification() {
        return datePlanification;
    }

    public void setDatePlanification(LocalDateTime datePlanification) {
        this.datePlanification = datePlanification;
    }

    public LocalDateTime getDateConfirmation() {
        return dateConfirmation;
    }

    public void setDateConfirmation(LocalDateTime dateConfirmation) {
        this.dateConfirmation = dateConfirmation;
    }

    public LocalDateTime getDateAnnulation() {
        return dateAnnulation;
    }

    public void setDateAnnulation(LocalDateTime dateAnnulation) {
        this.dateAnnulation = dateAnnulation;
    }

    public LocalDateTime getDateEnCabinet() {
        return dateEnCabinet;
    }

    public void setDateEnCabinet(LocalDateTime dateEnCabinet) {
        this.dateEnCabinet = dateEnCabinet;
    }

    public LocalDateTime getDateConsultation() {
        return dateConsultation;
    }

    public void setDateConsultation(LocalDateTime dateConsultation) {
        this.dateConsultation = dateConsultation;
    }

    public LocalDateTime getDateFinalisation() {
        return dateFinalisation;
    }

    public void setDateFinalisation(LocalDateTime dateFinalisation) {
        this.dateFinalisation = dateFinalisation;
    }

    public boolean getSansRdv() {
        return sansRdv;
    }

    public void setSansRdv(boolean sansRdv) {
        this.sansRdv = sansRdv;
    }

    public boolean getInitiationPatient() {
        return initiationPatient;
    }

    public void setInitiationPatient(boolean initiationPatient) {
        this.initiationPatient = initiationPatient;
    }

    public String getBg() {
        return rdvState.bg();
    }

    public void setBg(String bg) {
        this.bg = bg;
    }

    public boolean isToconfirm() {
        return rdvState.toConfirm();
    }

    public void setToconfirm(boolean toconfirm) {
        this.toconfirm = toconfirm;
    }

    public boolean isTodiscard() {
        return rdvState.toDiscard();
    }

    public String getMessageConfirmation() {
        return rdvState.messageConfirmer(this);
    }

    public void setMessageConfirmation(String messageConfirmation) {
        this.messageConfirmation = messageConfirmation;
    }

    public String getMessageAnnulation() {
        return rdvState.messageAnnulation(this);
    }

    public void setMessageAnnulation(String messageAnnulation) {
        this.messageAnnulation = messageAnnulation;
    }

    public void setTodiscard(boolean todiscard) {
        this.todiscard = todiscard;
    }

    private String statut;
    @JsonIgnore
    private RdvState rdvState;


    public RdvDto() {


    }
    RdvState rdvState(String state) {
        RdvState rdvState = new RdvInitiationState();
        if(state!=null){
            switch (state) {
                case "annulé": {
                    rdvState = new RdvAnnuleState();
                    break;
                }
                case "planifié": {
                    rdvState = new RdvPlanifieState();
                    break;
                }
                case "confirmé": {
                    rdvState = new RdvConfirmeState();
                    break;
                }
                case "initié": {
                    System.out.println("voila l'initiation");
                    rdvState = new RdvInitiationState();
                    break;
                }
                case "en consultation": {
                    rdvState = new RdvMedecinEnCabinetState();
                    break;
                }
                case "en cabinet": {
                    rdvState = new RdvPatientEnCabinetState();
                    break;
                }
                case "finalisé": {
                    rdvState = new RdvFinaliseState();
                    break;
                }
                default:
                    System.out.println("ne trouve aucun etat");
                    break;
            }}
        System.out.println(rdvState.statusName());
        return rdvState;
    }
    public void start() {
        if (this.getId() == null) {
      if(!this.getSansRdv()) {
          if (this.getInitiationPatient()) this.setRdvState(new RdvInitiationState());
          else{
              this.setRdvState(new RdvPlanifieState());
          }}else{
          this.setRdvState(new RdvPatientEnCabinetState());
      }

        }
        else{
            System.out.println("finding for etat "+getStatut());
            this.setRdvState(rdvState(this.getStatut()));
        }
        rdvState.start(this); }

    public RdvState getRdvState() {
        return rdvState;
    }

    public void setRdvState(RdvState rdvState) {
        this.rdvState = rdvState;
    }

// Getters and setters


    public PatientDto getPatient() {
        return patient;
    }

    public void setPatient(PatientDto patient) {
        this.patient = patient;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }


    public String getStatut() {
        return statut;
    }


    public void setStatut(String statut) {
        this.statut = statut;
    }


    public void annuler() throws ImpossibleTransactionWorkflow {
        rdvState.annuler(this);
    }

    public void confirmer() throws ImpossibleTransactionWorkflow {
        rdvState.confirmer(this);
    }


}

