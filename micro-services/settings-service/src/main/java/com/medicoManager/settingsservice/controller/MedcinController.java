package com.medicoManager.settingsservice.controller;

import com.medicoManager.settingsservice.dto.MedcinDto;
import com.medicoManager.settingsservice.model.Medcin;
import com.medicoManager.settingsservice.service.MedcinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users/medcin")
public class MedcinController extends AbstractUserController<Medcin, MedcinDto> {


}


