import { Component, OnInit } from '@angular/core';
import { GenericClientService } from '../services/http/generic-client.service';

@Component({
  selector: 'app-home-trial',
  templateUrl: './home-trial.component.html',
  styleUrls: ['./home-trial.component.scss']
})
export class HomeTrialComponent implements OnInit {

  rdvPlanifieTodays=[]
  rdvConsultationTodays=[]
  rdvFinalises=[]
    constructor(private clientHttp:GenericClientService) { }
  diffHours(d:Date){
    const givenDate = new Date(d);
  
  // Date et heure actuelles
  const currentDate = new Date();
  
  // Calcul de la différence en minutes
  const diffInMinutes = Math.round((currentDate.getTime() - givenDate.getTime()) / (1000 * 60));
  
  return diffInMinutes;
  }
    confirmer(rdv){
      this.clientHttp.post('rdv/confirmer',rdv).subscribe(
        data=>{
          this.clientHttp.get('rdv').subscribe(
            res=>this.updateList()
          )
        }
      )
      }
    updateList(){
    let s="en cabinet"
    let ss="en consultation"
    this.clientHttp.get('rdv/today/'+s).subscribe(
      data=>this.rdvPlanifieTodays=data
    ) 
    this.clientHttp.get('rdv/today/'+ss).subscribe(
      data=>this.rdvConsultationTodays=data
    )
    this.clientHttp.get('rdv/today/finalisé').subscribe(
      data=>this.rdvFinalises=data
    ) 
  }
    ngOnInit(): void {
  this.updateList()}
  
  
}
