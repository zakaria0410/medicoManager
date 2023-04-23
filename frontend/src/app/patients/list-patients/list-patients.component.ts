import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-list-patients',
  templateUrl: './list-patients.component.html',
  styleUrls: ['./list-patients.component.scss']
})
export class ListPatientsComponent implements OnInit {
user_choise='all'

choise(s){
this.user_choise=s
}

  constructor() { }

  ngOnInit(): void {
  }

}
