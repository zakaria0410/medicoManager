package com.medicoManager.settingsservice.mapper;

import com.medicoManager.settingsservice.dto.BaseDTO;
import com.medicoManager.settingsservice.model.BaseEntity;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

public abstract class BaseEntityMapperService<E extends BaseEntity, D extends BaseDTO> {


    public E toEntity(D dto) {
        E entity = instanciateEntity();
        entity.setId(dto.getId());
        return entity;
    }
    public abstract D instanciateDto();
    public abstract E instanciateEntity();


    protected abstract Class<D> getDtoClass();

    protected abstract Class<E> getEntityClass();


    public D toDto(E e) {

        D dto=instanciateDto();

        dto.setId(e.getId());
        return dto;
    }
}
