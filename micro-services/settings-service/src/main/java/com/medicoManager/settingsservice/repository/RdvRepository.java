package com.medicoManager.settingsservice.repository;

import com.medicoManager.settingsservice.model.Acte;
import com.medicoManager.settingsservice.model.Rdv;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface RdvRepository extends BaseRepository<Rdv> {
    @Query("select DISTINCT r.date from Rdv r")
    List<LocalDate> DistinctsDatesOfRdvs();

    @Query("select DISTINCT r.heure from Rdv r where r.date= :date")
    List<String> DistinctsHoursOfDate(LocalDate date);

    List<Rdv> findByDateAndHeure(LocalDate date, String heure);

    List<Rdv> findByDateAndStatut(LocalDate date, String statut);

    List<Rdv> findByDate(LocalDate date);






}

