import { Component, OnInit } from '@angular/core';
import { GenericClientService } from 'src/app/services/http/generic-client.service';

@Component({
  selector: 'app-bilans',
  templateUrl: './bilans.component.html',
  styleUrls: ['./bilans.component.scss']
})
export class BilansComponent implements OnInit {
  bilans=[]
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
  constructor(private httpClient:GenericClientService) { }

  ngOnInit(): void {
  this.fetchBilans()}

}
