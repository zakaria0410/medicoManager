import { Component, OnInit } from '@angular/core';
import { Subject, debounceTime } from 'rxjs';
import { GenericClientService } from 'src/app/services/http/generic-client.service';

@Component({
  selector: 'app-matiere-premiere',
  templateUrl: './matiere-premiere.component.html',
  styleUrls: ['./matiere-premiere.component.scss']
})
export class MatierePremiereComponent implements OnInit {
  bilan={description:null,name:null,unite_mesure:null}
  bilans=[]
  isSearch = false;
  inputValueSubject = new Subject<string>();
  initiateBilan() {
    if (this.isSearch == true) {
      this.isSearch = false;
      this.inputValueSubject.next('')
      this.bilan = {
        name: null,
     

        unite_mesure: null,
        description: null,

      }; 
    }
    else this.isSearch=true
  }
  fetchBilans(): void {
    this.httpClient.get('matiere-premiere').subscribe(
      (data) => {
        this.bilans = data;
      },
      (error) => {
        console.error('Failed to fetch ordonance types:', error);
      }
    );
  }
  constructor(private httpClient:GenericClientService) { }

  ngOnInit(): void {
  this.fetchBilans()
  this.inputValueSubject
  .pipe(debounceTime(300))
  .subscribe((value) =>
    this.httpClient
      .post('matiere-premiere/search', this.bilan)
      .subscribe((data) => (this.bilans = data))
  );}
}
