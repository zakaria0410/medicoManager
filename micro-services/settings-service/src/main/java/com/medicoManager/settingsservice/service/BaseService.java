package com.medicoManager.settingsservice.service;

import com.medicoManager.settingsservice.dto.BaseDTO;
import com.medicoManager.settingsservice.mapper.BaseEntityMapperService;
import com.medicoManager.settingsservice.model.BaseEntity;
import com.medicoManager.settingsservice.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class BaseService<E extends BaseEntity, D extends BaseDTO> {

    @Autowired
    private BaseRepository<E> repository;
    @Autowired
    private BaseEntityMapperService<E, D> entityMapperService;


    public D create(D dto) {
        E entity =
                entityMapperService.toEntity(dto);
        entity = repository.save(entity);
        return entityMapperService.toDto(entity);
    }

    public D update(D dto) {
        E entity = entityMapperService.toEntity(dto);
        entity = repository.save(entity);
        return entityMapperService.toDto(entity);
    }

    public D getById(Long id) {
        Optional<E> optionalEntity = repository.findById(id);
        if (optionalEntity.isPresent()) return entityMapperService.toDto(optionalEntity.get());
        else return null;
    }

    public List<D> getAll() {
        List<E> entities = repository.findAll();
        return entities.stream()
                .map(entity -> entityMapperService.toDto(entity))
                .collect(Collectors.toList());
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}



