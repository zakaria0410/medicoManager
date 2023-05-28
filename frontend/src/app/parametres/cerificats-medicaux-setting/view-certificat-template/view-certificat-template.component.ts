import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
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
@Input()  certificatData
  @Input() id
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
        'http://localhost:8080/api/certif/generate-certificat/'+this.id,
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
