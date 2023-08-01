package com.medicoManager.settingsservice.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "rendez_vous")
public class Rdv extends BaseEntity {


    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "medcin_id")
    private Medcin medcin;


    private LocalDate date;

    private String heure;
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

    private String statut;

    public Rdv() {
    }

    public Rdv(Patient patient, LocalDate date, String heure) {
        this.patient = patient;
        this.date = date;
        this.heure = heure;

    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
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

    public Medcin getMedcin() {
        return medcin;
    }

    public void setMedcin(Medcin medcin) {
        this.medcin = medcin;
    }
}

