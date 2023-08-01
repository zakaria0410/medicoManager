import { Component, OnInit } from '@angular/core';
import { GenericClientService } from '../services/http/generic-client.service';

@Component({
  selector: 'app-salle-attente',
  templateUrl: './salle-attente.component.html',
  styleUrls: ['./salle-attente.component.scss']
})
export class SalleAttenteComponent implements OnInit {
rdvs=[]
  constructor(private clientHttp:GenericClientService) { }

  ngOnInit(): void {
    this.clientHttp.get('rdv/today/all').subscribe(
      data=>this.rdvs=data
    )
  }

}
