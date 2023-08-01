import { Component, OnInit } from '@angular/core';
import { Subject, debounceTime } from 'rxjs';
import { GenericClientService } from 'src/app/services/http/generic-client.service';

@Component({
  selector: 'app-parametres-vitaux',
  templateUrl: './parametres-vitaux.component.html',
  styleUrls: ['./parametres-vitaux.component.scss']
})
export class ParametresVitauxComponent implements OnInit {
  parametresVitaux = [];
  parametreVital = {
    description: null,
    name: null,

    uniteMesure: null,
  };
  inputValue: string;
  inputValueSubject = new Subject<string>();
  isSearch:boolean = false;
  
  constructor(private clientHttp: GenericClientService) {}
  
  initiateParametreVital() {
    if (this.isSearch == true) {
      this.isSearch = false;
      Object.keys(this.parametreVital).forEach((s) => (this.parametreVital[s] = null));
      console.log(this.parametreVital);
      this.inputValueSubject.next("");
    } else {
      this.isSearch = true;
    }
  }
  
  ngOnInit(): void {
    this.clientHttp
      .get('parametres-vitaux')
      .subscribe((data) => (this.parametresVitaux = data));
    this.inputValueSubject
      .pipe(debounceTime(300))
      .subscribe((value) =>
        this.clientHttp
          .post('parametres-vitaux/search', this.parametreVital)
          .subscribe((data) => (this.parametresVitaux = data))
      );
  }
  
  callApi(value: string) {
    this.clientHttp.get('parametres-vitaux/nom/' + value).subscribe((response) => {
      this.parametresVitaux = response;
    });
  }
  

}
