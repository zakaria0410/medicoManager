package com.medicoManager.settingsservice.repository;

import com.medicoManager.settingsservice.model.AbstractPersonne;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface AbstractPersonneRepository<T extends AbstractPersonne> extends BaseRepository<T> {

}