package com.medicoManager.settingsservice.docUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/pdf")
public class PdfDownloadController {
    private final PdfGenerationService pdfGenerationService;

    @Autowired
    public PdfDownloadController(PdfGenerationService pdfGenerationService) {
        this.pdfGenerationService = pdfGenerationService;
    }

    @GetMapping("/telecharger-pdf")
    @ResponseBody
    public ResponseEntity<byte[]> telechargerPdf() throws Exception {
        byte[] pdfContent = pdfGenerationService.genererPdf();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "template.pdf");
        headers.setContentLength(pdfContent.length);

        return ResponseEntity.ok()
                .headers(headers)
                .body(pdfContent);
    }
}
