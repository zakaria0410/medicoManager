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
  inputValue: string;
   inputValueSubject = new Subject<string>();
  constructor(private clientHttp: GenericClientService) {}

  ngOnInit(): void {
    this.clientHttp
      .get('medicament')
      .subscribe((data) => (this.medicaments = data));
      this.inputValueSubject
      .pipe(debounceTime(300))
      .subscribe(value => this.callApi(value));
  }
  callApi(value: string) {
    // Utilisez HttpClient pour effectuer votre appel API avec la valeur fournie
    this.clientHttp.get('medicament/name/' + value)
      .subscribe(response => {
        this.medicaments=response
      });
  }
 
}
