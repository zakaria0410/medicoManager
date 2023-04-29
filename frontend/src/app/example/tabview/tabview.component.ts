import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-tabview',
  templateUrl: './tabview.component.html',
  styleUrls: ['./tabview.component.scss']
})
export class TabviewComponent implements OnInit {
  showTab2 = false;

  showTabTwo() {
    this.showTab2 = true;
  }
  constructor() { }

  ngOnInit(): void {
  }

}
