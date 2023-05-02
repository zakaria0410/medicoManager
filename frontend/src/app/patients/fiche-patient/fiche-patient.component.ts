import { Component, OnInit, ViewChild } from '@angular/core';
import { TabsetComponent } from 'ngx-bootstrap/tabs';

@Component({
  selector: 'app-fiche-patient',
  templateUrl: './fiche-patient.component.html',
  styleUrls: ['./fiche-patient.component.scss']
})
export class FichePatientComponent implements OnInit {
  @ViewChild('tabset') tabset: TabsetComponent;
  dents1=[18,17,16,15,14,13,12,11]

  dents2=[21,22,23,24,25,26,27,28]
  dents3=[31,32,33,34,35,36,37,38]
  dents4=[48,47,46,45,44,43,42,41]
  clicked=[]
  clickDent(d:any){
  if(!this.isexist(d))  this.clicked.push(d)
  else this.clicked=this.clicked.filter(dd=>dd!=d)
  }
isexist(d):any{
  return this.clicked.filter(dd=>dd==d).length>0
}


  handleTab2() {
    // Activer le deuxième onglet
    this.tabset.tabs[1].active = true;}
  constructor() { }

  ngOnInit(): void {
  }

}
