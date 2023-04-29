import { Component, OnInit, ViewChild } from '@angular/core';
import { TabsetComponent } from 'ngx-bootstrap/tabs';

@Component({
  selector: 'app-fiche-patient',
  templateUrl: './fiche-patient.component.html',
  styleUrls: ['./fiche-patient.component.scss']
})
export class FichePatientComponent implements OnInit {
  @ViewChild('tabset') tabset: TabsetComponent;
  handleTab2() {
    // Activer le deuxième onglet
    this.tabset.tabs[1].active = true;}
  constructor() { }

  ngOnInit(): void {
  }

}
