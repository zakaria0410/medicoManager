import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-table-calendar',
  templateUrl: './table-calendar.component.html',
  styleUrls: ['./table-calendar.component.scss']
})
export class TableCalendarComponent implements OnInit {
today=true
  constructor() { }

  ngOnInit(): void {
  }

}
