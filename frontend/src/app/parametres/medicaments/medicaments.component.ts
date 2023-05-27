import { Component, OnInit } from '@angular/core';
import { Subject, debounceTime } from 'rxjs';
import { GenericClientService } from 'src/app/services/http/generic-client.service';

@Component({
  selector: 'app-medicaments',
  templateUrl: './medicaments.component.html',
  styleUrls: ['./medicaments.component.scss'],
})
export class MedicamentsComponent implements OnInit {
  medicaments = [];
  medicament = {
    description: null,
    name: null,
    dosage: null,
    contreIndication: null,
    fabricant: null,
  };
  inputValue: string;
  inputValueSubject = new Subject<string>();
  isSearch:boolean = false;
  constructor(private clientHttp: GenericClientService) {}
  initiateMedicament() {
    if(this.isSearch==true){
      this.isSearch=false
      Object.keys(this.medicament).forEach((s) => (this.medicament[s] = null));
      console.log(this.medicament)
      this.inputValueSubject.next("")
    }else{
      this.isSearch=true
    }

  }
  ngOnInit(): void {
    this.clientHttp
      .get('medicament')
      .subscribe((data) => (this.medicaments = data));
    this.inputValueSubject
      .pipe(debounceTime(300))
      .subscribe((value) =>
        this.clientHttp
          .post('medicament/search', this.medicament)
          .subscribe((data) => (this.medicaments = data))
      );
  }
  callApi(value: string) {
    // Utilisez HttpClient pour effectuer votre appel API avec la valeur fournie
    this.clientHttp.get('medicament/name/' + value).subscribe((response) => {
      this.medicaments = response;
    });
  }
}
