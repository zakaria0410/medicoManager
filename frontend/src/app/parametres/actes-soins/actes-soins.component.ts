import { Component, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { Subject, debounceTime } from 'rxjs';
import { GenericClientService } from 'src/app/services/http/generic-client.service';

@Component({
  selector: 'app-actes-soins',
  templateUrl: './actes-soins.component.html',
  styleUrls: ['./actes-soins.component.scss'],
})
export class ActesSoinsComponent implements OnInit,OnChanges {
  actes = [];
  inputValue: string;
  inputValueSubject = new Subject<string>();
  constructor(private clientHttp: GenericClientService) {}
  ngOnChanges(changes: SimpleChanges): void {
    if(changes["acte"]){
      console.log("changement",changes["acte"].currentValue)
      this.clientHttp.post('acte/search',this.acte).subscribe(
        data=>this.actes=data
      )
    }
  }
  delete(id){
    this.clientHttp.delete(id,'acte').subscribe(
      data=>this.clientHttp.post('acte/search',this.acte).subscribe(
        data=>this.actes=data
      ))
    
  }
  ngOnInit(): void {
    this.clientHttp.get('acte').subscribe((data) => (this.actes = data));
    this.inputValueSubject
      .pipe(debounceTime(300))
      .subscribe((value) => this.clientHttp.post('acte/search',this.acte).subscribe(
        data=>this.actes=data
      ));
  }
  callApi(value: string) {
    // Utilisez HttpClient pour effectuer votre appel API avec la valeur fournie
    this.clientHttp.get('acte/name/' + value).subscribe((response) => {
      this.actes = response;
    });
  }

  acte = {
    codification: null,
    description: null,
    name: null,
    prix_unitaire: null,
  };
}
