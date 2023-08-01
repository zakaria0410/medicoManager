package com.medicoManager.settingsservice.controller;

import com.medicoManager.settingsservice.dto.AbstractPersonneDto;
import com.medicoManager.settingsservice.model.AbstractPersonne;
import com.medicoManager.settingsservice.service.AbstractPersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


public abstract class AbstractPersonneController<T extends AbstractPersonne,D extends AbstractPersonneDto> extends BaseEntityController<T,D> {

    @Autowired
    private AbstractPersonneService<T,D> service;




}

