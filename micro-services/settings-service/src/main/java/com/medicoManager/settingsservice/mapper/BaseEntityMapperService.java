package com.medicoManager.settingsservice.mapper;

import com.medicoManager.settingsservice.dto.BaseDTO;
import com.medicoManager.settingsservice.model.BaseEntity;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.InvocationTargetException;

public abstract class BaseEntityMapperService<E extends BaseEntity, D extends BaseDTO> {
    public E toEntity(D dto) {
        E entity = null;
        try {
            entity = getEntityClass().getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException("Failed to create entity instance", e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }

    public D toDto(E entity) {
        D dto = null;
        try {
            dto = getDtoClass().getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException("Failed to create DTO instance", e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }
    protected abstract Class<D> getDtoClass();
    protected abstract Class<E> getEntityClass();

}
