package com.medicoManager.settingsservice.repository;

import com.medicoManager.settingsservice.model.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<E extends BaseEntity> extends JpaRepository<E, Long> {
    // add any custom methods here as needed
}
