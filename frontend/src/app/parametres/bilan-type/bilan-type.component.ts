import { Component, OnInit } from '@angular/core';
import { GenericClientService } from 'src/app/services/http/generic-client.service';

@Component({
  selector: 'app-bilan-type',
  templateUrl: './bilan-type.component.html',
  styleUrls: ['./bilan-type.component.scss']
})
export class BilanTypeComponent implements OnInit {
  bilanTypes: any[];

  constructor(private clientHttp: GenericClientService) { }

  ngOnInit(): void {
    this.fetchOrdonanceTypes();
  }
delete(id){
  this.clientHttp.delete(id,'bilan-type').subscribe(
    data=>this.fetchOrdonanceTypes()
  )
}
  fetchOrdonanceTypes(): void {
    this.clientHttp.get('bilan-type').subscribe(
      (data) => {
        this.bilanTypes = data;
      },
      (error) => {
        console.error('Failed to fetch ordonance types:', error);
      }
    );
  }


}
