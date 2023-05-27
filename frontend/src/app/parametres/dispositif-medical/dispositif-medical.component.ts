import { Component, OnInit } from '@angular/core';
import { Subject, debounceTime } from 'rxjs';
import { GenericClientService } from 'src/app/services/http/generic-client.service';

@Component({
  selector: 'app-dispositif-medical',
  templateUrl: './dispositif-medical.component.html',
  styleUrls: ['./dispositif-medical.component.scss']
})
export class DispositifMedicalComponent implements OnInit {
  bilans=[]
  dispositif={name:"",description:"",unite_mesure:""}
isSearch  =false
  fetchBilans(): void {
    this.httpClient.get('dispositif-medical').subscribe(
      (data) => {
        this.bilans = data;
      },
      (error) => {
        console.error('Failed to fetch ordonance types:', error);
      }
    );
  }
  constructor(private httpClient:GenericClientService) { }
  inputValueSubject = new Subject<string>();
  ngOnInit(): void {
  this.fetchBilans()
  this.inputValueSubject
      .pipe(debounceTime(300))
      .subscribe((value) => this.httpClient.post('dispositif-medical/search',this.dispositif).subscribe(
        data=>this.bilans=data
      ));
  }
}