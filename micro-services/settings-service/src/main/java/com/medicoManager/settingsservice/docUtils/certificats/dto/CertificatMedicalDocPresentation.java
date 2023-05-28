package com.medicoManager.settingsservice.docUtils.certificats.dto;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CertificatMedicalDocPresentation {

    private String doctorName;
    private String doctorPhone;
    private String doctorEmail;
    private String patientName;
    private String patientBirthDate;
    private String patientAddress;
    private String startDate;
    private String endDate;
    private String healthCondition;
    private String recommendedDuration;

    // Constructeur, getters et setters

    public CertificatMedicalDocPresentation() {
    }

    public CertificatMedicalDocPresentation(String doctorName, String doctorPhone, String doctorEmail, String patientName, String patientBirthDate, String patientAddress, String startDate, String endDate, String healthCondition, String recommendedDuration) {
        this.doctorName = doctorName;
        this.doctorPhone = doctorPhone;
        this.doctorEmail = doctorEmail;
        this.patientName = patientName;
        this.patientBirthDate = patientBirthDate;
        this.patientAddress = patientAddress;
        this.startDate = startDate;
        this.endDate = endDate;
        this.healthCondition = healthCondition;
        this.recommendedDuration = recommendedDuration;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorPhone() {
        return doctorPhone;
    }

    public void setDoctorPhone(String doctorPhone) {
        this.doctorPhone = doctorPhone;
    }

    public String getDoctorEmail() {
        return doctorEmail;
    }

    public void setDoctorEmail(String doctorEmail) {
        this.doctorEmail = doctorEmail;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientBirthDate() {
        return patientBirthDate;
    }

    public void setPatientBirthDate(String patientBirthDate) {
        this.patientBirthDate = patientBirthDate;
    }

    public String getPatientAddress() {
        return patientAddress;
    }

    public void setPatientAddress(String patientAddress) {
        this.patientAddress = patientAddress;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getHealthCondition() {
        return healthCondition;
    }

    public void setHealthCondition(String healthCondition) {
        this.healthCondition = healthCondition;
    }

    public String getRecommendedDuration() {
        return recommendedDuration;
    }

    public void setRecommendedDuration(String recommendedDuration) {
        this.recommendedDuration = recommendedDuration;
    }
}


