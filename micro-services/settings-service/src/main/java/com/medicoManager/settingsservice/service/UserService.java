package com.medicoManager.settingsservice.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import com.medicoManager.settingsservice.dto.MedicamentDto;
import com.medicoManager.settingsservice.dto.PatientDto;
import com.medicoManager.settingsservice.dto.UserDto;
import com.medicoManager.settingsservice.mapper.PatientMapperService;
import com.medicoManager.settingsservice.model.Medicament;
import com.medicoManager.settingsservice.model.Patient;
import com.medicoManager.settingsservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService extends AbstractUserService<User, UserDto> {

    @Override
    protected Class<UserDto> getDtoClass() {
        return UserDto.class;
    }
    @Override
    public List<UserDto> mapJsonToDto(MultipartFile file) {
        try {
            return new ObjectMapper().readValue(file.getInputStream(), new TypeReference<List<UserDto>>() {});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    protected Class<User> getEntityClass() {
        return User.class;
    }

}

