import { Component, OnInit } from '@angular/core';
import { Subject, debounceTime } from 'rxjs';
import { GenericClientService } from 'src/app/services/http/generic-client.service';

@Component({
  selector: 'app-ordonance-type',
  templateUrl: './ordonance-type.component.html',
  styleUrls: ['./ordonance-type.component.scss']
})
export class OrdonanceTypeComponent implements OnInit {
  ordonanceTypes: any[];
isSearch=false
ordonanceType={name:null,description:null}
inputValueSubject = new Subject<string>();

  constructor(private clientHttp: GenericClientService) { }

  ngOnInit(): void {
    this.fetchOrdonanceTypes();
    this.inputValueSubject
    .pipe(debounceTime(300))
    .subscribe((value) => this.clientHttp.post('ordonance-type/search',this.ordonanceType).subscribe(
      data=>this.ordonanceTypes=data
    ));
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
