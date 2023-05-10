package com.medicoManager.settingsservice.controller;

import java.util.List;
import java.util.Optional;

import com.medicoManager.settingsservice.dto.BaseDTO;
import com.medicoManager.settingsservice.model.BaseEntity;
import com.medicoManager.settingsservice.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


public abstract class BaseEntityController<T extends BaseEntity,D extends BaseDTO> {

    @Autowired
    private BaseService<T,D> service;

    @GetMapping
    public List<D> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public D getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public D create(@RequestBody D entity) {
        return service.create(entity);
    }


    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }
}


