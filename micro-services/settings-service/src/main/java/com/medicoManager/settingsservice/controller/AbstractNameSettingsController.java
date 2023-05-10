package com.medicoManager.settingsservice.controller;

import java.util.List;
import java.util.Optional;

import com.medicoManager.settingsservice.dto.AbstractNameSettingsDto;
import com.medicoManager.settingsservice.model.AbstractNameSettings;
import com.medicoManager.settingsservice.service.AbstractNameSettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


public abstract class AbstractNameSettingsController<T extends AbstractNameSettings,D extends AbstractNameSettingsDto> extends BaseEntityController<T,D> {

    @Autowired
    private AbstractNameSettingsService<T,D> service;

    @GetMapping("/name/{name}")
    public List<D> getAllByName(@PathVariable String name) {
        return service.getAllByName(name);
    }


}

