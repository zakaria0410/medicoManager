package com.medicoManager.settingsservice.calendar;

import com.medicoManager.settingsservice.dto.RdvDto;

import java.util.Date;
import java.util.HashMap;

public class CalendarObject {
    private String jour;
    private Date date;
    private HashMap<String, RdvDto> rdvs;

    public String getJour() {
        return jour;
    }

    public void setJour(String jour) {
        this.jour = jour;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public HashMap<String, RdvDto> getRdvs() {
        return rdvs;
    }

    public void setRdvs(HashMap<String, RdvDto> rdvs) {
        this.rdvs = rdvs;
    }


}
