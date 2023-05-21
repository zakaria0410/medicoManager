package com.medicoManager.settingsservice.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.medicoManager.settingsservice.dto.BaseDTO;
import com.medicoManager.settingsservice.model.BaseEntity;
import com.medicoManager.settingsservice.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin("*")
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

    @PostMapping("/save")
    public D create(@RequestBody D entity) {
        return service.create(entity);
    }


    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }


    @PostMapping(value = "/upload-mock-data")
    public ResponseEntity<List<D>> createItems(@RequestParam("file") MultipartFile file) {

            List<D> items = service.mapJsonToDto(file);
         //   service.saveAll(items);
            return new ResponseEntity<>(service.saveAll(items), HttpStatus.CREATED);

    }
    @PostMapping(value = "/save-all")
    public List<D> createItems(@RequestBody List<D> dtos) {

        //     List<D> items = new ObjectMapper().readValue(file.getInputStream(), new TypeReference<List<D>>() {});
            service.saveAll(dtos);
        return dtos;


    }

}


