package com.medicoManager.settingsservice.repository;


import com.medicoManager.settingsservice.model.User;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface AbstractUserRepository<T extends User> extends AbstractPersonneRepository<T> {

}