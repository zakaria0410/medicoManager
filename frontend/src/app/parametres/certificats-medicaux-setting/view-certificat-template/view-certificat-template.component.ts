import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { GenericClientService } from 'src/app/services/http/generic-client.service';
const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json',
    'Accept':'*/*'

  })
};
const httpOptionMultipart = {
  headers: new HttpHeaders({
    "Content-Type": "multipart/form-data"

  })
};
@Component({
  selector: 'app-view-certificat-template',
  templateUrl: './view-certificat-template.component.html',
  styleUrls: ['./view-certificat-template.component.scss'],
})
export class ViewCertificatTemplateComponent implements OnInit {
  certificatData = {
    doctorName: 'Dr. Jean Dupont',
    doctorPhone: '01 234 5678',
    doctorEmail: 'jean.dupont@example.com',
    patientName: 'Alice Martin',
    patientBirthDate: '15/03/1985',
    patientAddress: '456 Rue Secondaire, Ville',
    startDate: '01/05/2023',
    endDate: '15/05/2023',
    healthCondition: 'En bonne santé',
    recommendedDuration: '2 semaines',
  };

  constructor(private http: HttpClient) {}
  ngOnInit(): void {
    //  throw new Error('Method not implemented.');
  }

  generateCertificat(): void {
    const httpOptions1 = {
      responseType: 'arraybuffer' as 'json',
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    };
    this.http
      .post(
        'http://localhost:8080/pdf/certif/generate-certificat',
        this.certificatData,
        { ...httpOptions1, }
      )
      .subscribe(response => {
        // Créer un objet Blob à partir du tableau d'octets
        const blob = new Blob([response as BlobPart], { type: 'application/octet-stream' });
  
        // Générer un nom de fichier pour le téléchargement
        const fileName = 'fichier_telecharge.pdf';
  
        // Créer un lien temporaire et définir les attributs pour le téléchargement
        const link = document.createElement('a');
        link.href = window.URL.createObjectURL(blob);
        link.download = fileName;
  
        // Simuler le clic sur le lien pour démarrer le téléchargement
        link.click();
  
        // Nettoyer les ressources temporaires
        window.URL.revokeObjectURL(link.href);
        link.remove();
      });
  }

  private downloadFile(blob: Blob): void {
    const link = document.createElement('a');
    link.href = URL.createObjectURL(blob);
    link.download = 'certificat.html';
    link.click();
  }
}
