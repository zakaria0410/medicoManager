package com.medicoManager.settingsservice.mapper;

import com.medicoManager.settingsservice.dto.PatientDto;
import com.medicoManager.settingsservice.dto.UserDto;
import com.medicoManager.settingsservice.model.Patient;
import com.medicoManager.settingsservice.model.User;
import com.medicoManager.settingsservice.service.AbstractUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public  class UserMapperService extends UserEntityMapperService<User, UserDto> {
    @Override
    public UserDto instanciateDto() {
        return new UserDto();
    }

    @Override
    public User instanciateEntity() {
        return new User();
    }

    @Override
    protected Class<UserDto> getDtoClass() {
        return UserDto.class;
    }

    @Override
    protected Class<User> getEntityClass() {
        return User.class;
    }

    ;

}
