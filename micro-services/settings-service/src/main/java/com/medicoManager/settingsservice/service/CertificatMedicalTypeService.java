package com.medicoManager.settingsservice.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.medicoManager.settingsservice.docUtils.certificats.dto.CertificatMedicalDocPresentation;
import com.medicoManager.settingsservice.dto.CertificatMedicalTypeDto;
import com.medicoManager.settingsservice.dto.CertificatMedicalTypeDto;
import com.medicoManager.settingsservice.dto.CertificatVariableDto;
import com.medicoManager.settingsservice.model.CertificatMedicalType;
import com.medicoManager.settingsservice.model.CertificatVariable;
import com.medicoManager.settingsservice.model.Medicament;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class CertificatMedicalTypeService extends AbstractNameSettingsService<CertificatMedicalType, CertificatMedicalTypeDto> {
    @Autowired
    private CertificatVariableService certificatVariableService;
    @Override
    protected Class<CertificatMedicalTypeDto> getDtoClass() {
        return CertificatMedicalTypeDto.class;
    }
    @Override
    public List<CertificatMedicalTypeDto> mapJsonToDto(MultipartFile file) {
        try {
            return new ObjectMapper().readValue(file.getInputStream(), new TypeReference<List<CertificatMedicalTypeDto>>() {});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    protected Class<CertificatMedicalType> getEntityClass() {
        return CertificatMedicalType.class;
    }

    public  List<String> detectVariables(String text) {
        List<String> variables = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\$\\{\\w+\\}");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            String variable = matcher.group();
            variables.add(variable);
        }

        return variables;
    }

    public CertificatMedicalDocPresentation certificatMedicalDocPresentationFromOrdonanceType(CertificatMedicalTypeDto certificatMedicalTypeDto) throws Exception {
        CertificatMedicalDocPresentation certificatMedicalDocPresentation=new CertificatMedicalDocPresentation();
        for (String variable: Arrays.stream(certificatMedicalDocPresentation.getClass().getDeclaredFields()).map(s->s.getName()).collect(Collectors.toList()) ){
            String variable1=variable.replaceAll("\\$\\{","");
            String variable2=variable1.replaceAll("\\}","");
            CertificatVariableDto certificatVariableDto=certificatVariableService.getUniqueByNameOrThrows(variable2);
            String setMethodName = "set" + variable2.substring(0, 1).toUpperCase() + variable2.substring(1);
            Method setVariableMethod = CertificatMedicalDocPresentation.class.getDeclaredMethod(setMethodName, String.class);
            setVariableMethod.invoke(certificatMedicalDocPresentation,certificatVariableDto.getDefaultValue());
        }
        return certificatMedicalDocPresentation;
    }
    public String paragrapheFromOrdonanceType(CertificatMedicalTypeDto certificatMedicalTypeDto) throws Exception {
        String paragraph="";

        for (String variable:detectVariables(certificatMedicalTypeDto.getParagraphe()) ){
            String variable1=variable.replaceAll("\\$\\{","");
            String variable2=variable1.replaceAll("\\}","");
            CertificatVariableDto certificatVariableDto=certificatVariableService.getUniqueByNameOrThrows(variable2);
          certificatMedicalTypeDto.setParagraphe(certificatMedicalTypeDto.getParagraphe().replace(variable,"<b>"+certificatVariableDto.getDefaultValue()+"</b>"));
        }
        return certificatMedicalTypeDto.getParagraphe();
    }



}

