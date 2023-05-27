package com.medicoManager.settingsservice.docUtils.certificats.controller;

import com.lowagie.text.DocumentException;
import com.medicoManager.settingsservice.docUtils.certificats.dto.CertificatMedicalDocPresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/certif")
@CrossOrigin("*")
public class CertificatMedicalDocPresentationController {
@Autowired
private  TemplateEngine templateEngine;
    public static List<String> getFields() {
        List<String> attributes = new ArrayList<>();

        Field[] fields = CertificatMedicalDocPresentation.class.getDeclaredFields();
        for (Field field : fields) {
            attributes.add(field.getName());
        }
      return attributes;
    }
    @GetMapping("/fields")
    public List<String> getAttributes(@PathVariable String name) {
        ;
        return getFields();
    }
    @PostMapping(value = "/generate-certificat", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<byte[]> generateCertificat(@RequestBody CertificatMedicalDocPresentation certificat) throws IOException, DocumentException {
        // Création du contexte Thymeleaf
        Context context = new Context();
        context.setVariable("certificat", certificat);

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

