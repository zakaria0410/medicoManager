import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-input-number',
  templateUrl: './input-number.component.html',
  styleUrls: ['./input-number.component.scss']
})
export class InputNumberComponent implements OnInit {
  @Input() label: string;
  @Input() value: any;
  @Input() placeholder: string;
  constructor() { }

  ngOnInit(): void {
  }

}
