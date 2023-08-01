package com.medicoManager.settingsservice.controller;


import com.medicoManager.settingsservice.dto.UserDto;
import com.medicoManager.settingsservice.model.User;


public abstract class AbstractUserController<T extends User,D extends UserDto> extends AbstractPersonneController<T,D> {

}

