import { Component, EventEmitter, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-main-menu',
  templateUrl: './main-menu.component.html',
  styleUrls: ['./main-menu.component.scss']
})
export class MainMenuComponent implements OnInit {
  isMenuOpen: boolean = false;
@Output() showMenu=new EventEmitter
  toggleMenu() {
    this.isMenuOpen = !this.isMenuOpen;
    this.showMenu.emit(true)
  }
  constructor() { }

  ngOnInit(): void {
  }

}
