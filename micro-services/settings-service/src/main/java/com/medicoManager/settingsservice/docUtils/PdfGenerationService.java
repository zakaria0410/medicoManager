package com.medicoManager.settingsservice.docUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.StringTemplateResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

@Service
public class PdfGenerationService {
    private final TemplateEngine templateEngine;

    @Autowired
    public PdfGenerationService(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    public byte[] genererPdf() throws Exception {
        // Créer un contexte et ajouter les données du modèle si nécessaire
        Context context = new Context();
        context.setVariable("templateText", "<b>ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ</b>");

        // ... Ajouter d'autres variables au besoin

        // Configuration du résolveur de template basé sur une chaîne de texte HTML
        //StringTemplateResolver stringTemplateResolver = new StringTemplateResolver();
        //stringTemplateResolver.setTemplateMode(TemplateMode.HTML);

        // Créer un moteur de template avec le résolveur de template personnalisé
        //TemplateEngine customTemplateEngine = new TemplateEngine();
        //customTemplateEngine.setTemplateResolver(stringTemplateResolver);

        // Rendre le texte HTML avec le moteur de template personnalisé
        String html = templateEngine.process("template.html", context);

        // Initialiser le renderer PDF avec ITextRenderer
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

        return pdfContent;
    }
}
