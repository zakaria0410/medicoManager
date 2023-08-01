package com.medicoManager.settingsservice.service;

import com.medicoManager.settingsservice.dto.AbstractPersonneDto;
import com.medicoManager.settingsservice.mapper.NameEntityMapperService;
import com.medicoManager.settingsservice.mapper.PersonEntityMapperService;
import com.medicoManager.settingsservice.model.AbstractPersonne;
import com.medicoManager.settingsservice.repository.AbstractPersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractPersonneService<T extends AbstractPersonne, D extends AbstractPersonneDto> extends BaseService<T, D> {

    @Autowired
    private AbstractPersonneRepository<T> repository;




}

