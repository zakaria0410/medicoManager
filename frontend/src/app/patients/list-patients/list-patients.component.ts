import { Component, OnInit } from '@angular/core';
import { Subject, debounceTime } from 'rxjs';
import { GenericClientService } from 'src/app/services/http/generic-client.service';

@Component({
  selector: 'app-list-patients',
  templateUrl: './list-patients.component.html',
  styleUrls: ['./list-patients.component.scss']
})
export class ListPatientsComponent implements OnInit {
  patients = [];
  patient = {
    nom: null,
    prenom: null,
    adresse: null,
    telephone1: null,
    telephone2: null,
    email: null,
    civilite: null,
    cin: null,
    nCnss: null,
    mutuelle: null,
    nMutuelle: null,
    numeroSecuriteSociale: null
  };
  inputValue: string;
  inputValueSubject = new Subject<string>();
  isSearch: boolean = false;

  constructor(private clientHttp: GenericClientService) {}

  initiatePatient() {
    if (this.isSearch == true) {
      this.isSearch = false;
      Object.keys(this.patient).forEach((s) => (this.patient[s] = null));
      this.inputValueSubject.next("");
    } else {
      this.isSearch = true;
    }
  }
genrateFakePatient(){
  this.clientHttp
  .get('patient/generate-patients')
  .subscribe((data) => (this.patients = data));
}
  ngOnInit(): void {
    this.clientHttp
      .get('patient')
      .subscribe((data) => (this.patients = data));
    this.inputValueSubject
      .pipe(debounceTime(300))
      .subscribe((value) =>
        this.clientHttp
          .post('patient/search', this.patient)
          .subscribe((data) => (this.patients = data))
      );
  }

  callApi(value: string) {
 console.log("from patients "+value)   // Utilisez HttpClient pour effectuer votre appel API avec la valeur fournie
    this.clientHttp
    .get('patient')
    .subscribe((data) => (this.patients = data));
  }

}
