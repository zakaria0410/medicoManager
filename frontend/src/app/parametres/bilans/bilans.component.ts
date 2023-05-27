import { Component, OnInit } from '@angular/core';
import { Subject, debounceTime } from 'rxjs';
import { GenericClientService } from 'src/app/services/http/generic-client.service';

@Component({
  selector: 'app-bilans',
  templateUrl: './bilans.component.html',
  styleUrls: ['./bilans.component.scss'],
})
export class BilansComponent implements OnInit {
  bilans = [];
  bilan = {
    name: null,
    numerique: null,
    uniteMesure: null,
    description: null,
    codification: null,
  };
  isSearch = false;
  inputValueSubject = new Subject<string>();
  initiateBilan() {
    if (this.isSearch == true) {
      this.isSearch = false;
      this.inputValueSubject.next('')
      this.bilan = {
        name: null,
        numerique: null,

        uniteMesure: null,
        description: null,
        codification: null,
      }; 
    }
    else this.isSearch=true
  }
  fetchBilans(): void {
    this.httpClient.get('bilan').subscribe(
      (data) => {
        this.bilans = data;
      },
      (error) => {
        console.error('Failed to fetch ordonance types:', error);
      }
    );
  }

  constructor(private httpClient: GenericClientService) {}

  ngOnInit(): void {
    this.fetchBilans();
    this.inputValueSubject
    .pipe(debounceTime(300))
    .subscribe((value) =>
      this.httpClient
        .post('bilan/search', this.bilan)
        .subscribe((data) => (this.bilans = data))
    );
  }
}
