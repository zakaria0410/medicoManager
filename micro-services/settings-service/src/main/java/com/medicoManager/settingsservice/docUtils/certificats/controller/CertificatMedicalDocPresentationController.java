package com.medicoManager.settingsservice.docUtils.certificats.controller;

import com.medicoManager.settingsservice.docUtils.certificats.dto.CertificatMedicalDocPresentation;
import com.medicoManager.settingsservice.dto.CertificatMedicalTypeDto;
import com.medicoManager.settingsservice.service.CertificatMedicalTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.ByteArrayOutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/certif")
@CrossOrigin("*")
public class CertificatMedicalDocPresentationController {
    @Autowired
    private TemplateEngine templateEngine;

    public static List<String> getFields() {
        List<String> attributes = new ArrayList<>();

        Field[] fields = CertificatMedicalDocPresentation.class.getDeclaredFields();
        for (Field field : fields) {
            attributes.add(field.getName());
        }
        return attributes;
    }

    @GetMapping("/fields")
    public List<String> getAttributes() {

        return getFields().stream().collect(Collectors.toList());
    }

    @Autowired
    private CertificatMedicalTypeService certificatMedicalTypeService;

    @PostMapping(value = "/generate-certificat/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<byte[]> generateCertificat(@PathVariable Long id, @RequestBody CertificatMedicalDocPresentation certificat) throws Exception {
        // Création du contexte Thymeleaf
        CertificatMedicalTypeDto certificatMedicalTypeDto = certificatMedicalTypeService.getById(id);
        String paragraph = certificatMedicalTypeService.paragrapheFromOrdonanceType(certificatMedicalTypeDto);
        Context context = new Context();
        context.setVariable("certificat", certificat);
        context.setVariable("title", certificatMedicalTypeDto.getTitle());
        context.setVariable("paragraph", paragraph);
        // Configuration du moteur de template Thymeleaf
        String html = templateEngine.process("certificat.html", context);
        // Conversion du contenu HTML en tableau de bytes
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(html);
        renderer.layout();


        // Générer le PDF dans un flux de sortie
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        renderer.createPDF(outputStream);

        // Récupérer le contenu du PDF en tant que tableau d'octets
        byte[] pdfContent = outputStream.toByteArray();

        // Fermer les flux
        outputStream.close();
        // Paramètres de la réponse HTTP pour le téléchargement du fichier
        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header("Content-Disposition", "attachment; filename=\"certificat.pdf\"")
                .body(pdfContent);
    }
}

