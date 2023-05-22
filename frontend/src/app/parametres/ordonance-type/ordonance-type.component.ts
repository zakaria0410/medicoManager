import { Component, OnInit } from '@angular/core';
import { GenericClientService } from 'src/app/services/http/generic-client.service';

@Component({
  selector: 'app-ordonance-type',
  templateUrl: './ordonance-type.component.html',
  styleUrls: ['./ordonance-type.component.scss']
})
export class OrdonanceTypeComponent implements OnInit {
  ordonanceTypes: any[];

  constructor(private clientHttp: GenericClientService) { }

  ngOnInit(): void {
    this.fetchOrdonanceTypes();
  }
delete(id){
  this.clientHttp.delete(id,'ordonance-type').subscribe(
    data=>this.fetchOrdonanceTypes()
  )
}
  fetchOrdonanceTypes(): void {
    this.clientHttp.get('ordonance-type').subscribe(
      (data) => {
        this.ordonanceTypes = data;
      },
      (error) => {
        console.error('Failed to fetch ordonance types:', error);
      }
    );
  }

}
