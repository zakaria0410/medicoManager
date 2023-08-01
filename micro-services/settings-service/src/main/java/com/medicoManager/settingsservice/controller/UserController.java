package com.medicoManager.settingsservice.controller;

import com.medicoManager.settingsservice.dto.BilanTypeDto;
import com.medicoManager.settingsservice.dto.UserDto;
import com.medicoManager.settingsservice.model.BilanType;
import com.medicoManager.settingsservice.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController extends AbstractUserController<User, UserDto> {
}


