package com.medicoManager.settingsservice.repository;

import com.medicoManager.settingsservice.model.AbstractNameSettings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface AbstractNameSettingsRepository<T extends AbstractNameSettings> extends BaseRepository<T> {
    List<T> findByNameIgnoreCase(String name);
    Optional<T> findByName(String name);
    // Add any additional custom methods for all name settings repositories here
}