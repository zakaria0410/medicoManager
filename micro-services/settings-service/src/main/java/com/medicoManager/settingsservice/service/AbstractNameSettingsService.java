package com.medicoManager.settingsservice.service;

import com.medicoManager.settingsservice.dto.AbstractNameSettingsDto;
import com.medicoManager.settingsservice.mapper.NameEntityMapperService;
import com.medicoManager.settingsservice.model.AbstractNameSettings;
import com.medicoManager.settingsservice.repository.AbstractNameSettingsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractNameSettingsService<T extends AbstractNameSettings, D extends AbstractNameSettingsDto> extends BaseService<T, D> {

    @Autowired
    private AbstractNameSettingsRepository<T> repository;
    @Autowired
    private NameEntityMapperService<T, D> nameEntityMapperService;

    public List<D> getAllByName(String name) {
        if (name.isBlank())
            return repository.findAll().stream().map(entity -> nameEntityMapperService.toDto(entity)).collect(Collectors.toList());
        else
            return repository.findAll().stream().filter(entity -> entity.getName().toLowerCase().contains(name.toLowerCase())).map(entity -> nameEntityMapperService.toDto(entity)).collect(Collectors.toList());
    }

    public D getUniqueByNameOrCreate(String name) {
         T entity=repository.findByName(name).orElse(null);
         if(entity!=null)return nameEntityMapperService.toDto(entity);
         else {
        entity=nameEntityMapperService.instanciateEntity();
        entity.setName(name);
        return create(nameEntityMapperService.toDto(entity));

         }
    }
    public D getUniqueByNameOrThrows(String name) throws Exception {
        T entity=repository.findByName(name).orElse(null);
        if(entity!=null)return nameEntityMapperService.toDto(entity);
        else {
        throw new Exception(getDtoClass().getName()+" Not Found");

        }
    }
}

