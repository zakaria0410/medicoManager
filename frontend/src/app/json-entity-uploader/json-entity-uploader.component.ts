import { HttpClient, HttpEvent, HttpEventType } from '@angular/common/http';
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-json-entity-uploader',
  templateUrl: './json-entity-uploader.component.html',
  styleUrls: ['./json-entity-uploader.component.scss']
})
export class JsonEntityUploaderComponent implements OnInit {
  selectedFile: File;
  uploadProgress: number;
  @Input() urlExport
  @Output() actionAcomplished=new EventEmitter
  constructor(private http: HttpClient) { }
  ngOnInit(): void {
 ///   throw new Error('Method not implemented.');
  }

  onFileSelected(event: any) {
    this.selectedFile = event.target.files.item(0);
  }

  uploadFile() {
    const formData: FormData = new FormData();
    formData.append('file', this.selectedFile);
console.log(this.selectedFile)
    this.http.post('http://localhost:8080/'+this.urlExport+'/upload-mock-data', formData, { reportProgress: true, observe: 'events' })
      .subscribe(
        (event: HttpEvent<any>) => {
          if (event.type === HttpEventType.UploadProgress) {
            this.uploadProgress = Math.round((event.loaded / event.total) * 100);
          } else if (event.type === HttpEventType.Response) {
            console.log('File uploaded successfully');
            this.actionAcomplished.emit(true)
            // Ajoutez ici le code pour gérer la réponse du serveur après l'upload
          }
        },
        error => {
          console.log('Error uploading file:', error);
          // Ajoutez ici le code pour gérer les erreurs d'upload
        }
      );
  }

}
